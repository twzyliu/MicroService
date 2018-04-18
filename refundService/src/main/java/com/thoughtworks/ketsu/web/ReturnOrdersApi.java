package com.thoughtworks.ketsu.web;

import com.google.gson.Gson;
import com.thoughtworks.ketsu.infrastructure.repositories.ReturnOrderRepository;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static com.thoughtworks.ketsu.util.HttpClient.doGet;
import static java.lang.System.getenv;
import static javax.ws.rs.core.Response.created;
import static javax.ws.rs.core.Response.status;

@Path("/return_orders")
public class ReturnOrdersApi {
    @Inject
    ReturnOrderRepository returnOrderRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Map<String, Object> info) throws URISyntaxException {
        Map order_map = getOrderMap(info.get("order_id") + "");
        
        info.put("amount", "0");
        returnOrderRepository.save(info);
        return info.containsKey("id") ?
                created(new URI("/return_orders/" + info.get("id"))).build() :
                status(400).build();
    }

    private Map getOrderMap(String oid) {
        String host = getenv().getOrDefault("ORDER_SERVICE_HOST", "127.0.0.1");
        String port = getenv().getOrDefault("ORDER_SERVICE_PORT", "23333");
        String order_json = doGet("http://" + host + ":" + port + "/orders/" + oid);
        return new Gson().fromJson(order_json, Map.class);
    }
}
