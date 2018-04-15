package com.thoughtworks.ketsu.web;

import com.google.gson.Gson;
import com.thoughtworks.ketsu.infrastructure.repositories.OrderRepository;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import static com.thoughtworks.ketsu.util.HttpClient.doGet;
import static java.lang.Integer.*;
import static javax.ws.rs.core.Response.created;
import static javax.ws.rs.core.Response.status;

@Path("/orders")
public class OrderApi {
    @Inject
    OrderRepository orderRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Map<String, Object> info) throws URISyntaxException {
        List<Map> order_items = (List<Map>) info.get("order_items");
        String amount = order_items.stream().
                map(order_item -> parseInt(getPrice(order_item)) * parseInt(order_item.get("quantity") + "")).
                reduce(0, (sum, element) -> sum + element) + "";

        info.put("amount", amount);
        orderRepository.save(info);
        return info.containsKey("id") ?
                created(new URI("/orders/" + info.get("id"))).build() :
                status(400).build();
    }

    private String getPrice(Map order_item) {
        String price_service_host_host = System.getenv().getOrDefault("PRICE_SERVICE_HOST", "127.0.0.1");
        String price_service_port = System.getenv().getOrDefault("PRICE_SERVICE_PORT", "21000");
        String priceMap = doGet("http://" + price_service_host_host + ":" + price_service_port + "/prices?product_id=" + order_item.get("product_id"));
        return new Gson().fromJson(priceMap, Map.class).get("price") + "";
    }
}
