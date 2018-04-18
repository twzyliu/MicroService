package com.thoughtworks.ketsu.web;

import com.google.gson.Gson;
import com.thoughtworks.ketsu.domain.returnOrder.ReturnOrder;
import com.thoughtworks.ketsu.infrastructure.repositories.ReturnOrderRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import static com.thoughtworks.ketsu.util.HttpClient.doGet;
import static java.lang.Integer.*;
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
        List<Map> order_items = (List<Map>) order_map.get("order_items");
        // todo check quantity

        List<Map> return_order_items = (List<Map>) info.get("return_order_items");
        int amount = 0;
        for (Map item : return_order_items) {
            String price = getPrice(item.get("product_id") + "");
            amount += parseInt(price) * parseInt(item.get("quantity") + "");
        }
        info.put("amount", amount);
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

    private String getPrice(String product_id) {
        String host = getenv().getOrDefault("PRICE_SERVICE_HOST", "127.0.0.1");
        String port = getenv().getOrDefault("PRICE_SERVICE_PORT", "23333");
        String price_json = doGet("http://" + host + ":" + port + "/prices?product_id=" + product_id);
        Map price_map = new Gson().fromJson(price_json, Map.class);
        return price_json.contains("price") ?
                price_map.get("price") + "" :
                "-1";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReturnOrder> getList() {
        return returnOrderRepository.getList();
    }
}
