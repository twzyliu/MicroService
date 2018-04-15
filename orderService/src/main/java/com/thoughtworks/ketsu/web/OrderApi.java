package com.thoughtworks.ketsu.web;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.thoughtworks.ketsu.infrastructure.repositories.OrderRepository;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.thoughtworks.ketsu.util.HttpClient.doGet;
import static com.thoughtworks.ketsu.util.HttpClient.doPost;
import static java.lang.Integer.parseInt;
import static java.lang.System.getenv;
import static java.util.stream.Collectors.toList;
import static javax.ws.rs.core.Response.created;
import static javax.ws.rs.core.Response.status;

@Path("/orders")
public class OrderApi {
    @Inject
    OrderRepository orderRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Map<String, Object> info) throws Exception {
        List<Map> order_items = (List<Map>) info.get("order_items");
        String amount = order_items.stream().
                map(order_item -> parseInt(getPrice(order_item)) * parseInt(order_item.get("quantity") + "")).
                reduce(0, (sum, element) -> sum + element) + "";

        info.put("amount", amount);
        orderRepository.save(info);
        createUnloading(order_items);
        return info.containsKey("id") ?
                created(new URI("/orders/" + info.get("id"))).build() :
                status(400).build();
    }

    private void createUnloading(List<Map> order_items) throws Exception {
        String host = getenv().getOrDefault("INVENTORY_SERVICE_HOST", "127.0.0.1");
        String port = getenv().getOrDefault("INVENTORY_SERVICE_PORT", "23333");
        List<Map> uploading = order_items.stream().map(order_item -> new HashMap() {{
            put("product_id", order_item.get("product_id"));
            put("quantity", order_item.get("quantity"));
            put("pay", "0");
        }}).collect(toList());
        Map uploadingMap = new HashMap() {{
            put("upploading", uploading);
        }};
        String uploading_str = new Gson().toJson(uploadingMap);
        doPost("http://" + host + ":" + port + "/unloadings", uploading_str);
    }

    private String getPrice(Map order_item) {
        String host = getenv().getOrDefault("PRICE_SERVICE_HOST", "127.0.0.1");
        String port = getenv().getOrDefault("PRICE_SERVICE_PORT", "23333");
        String priceMap = doGet("http://" + host + ":" + port + "/prices?product_id=" + order_item.get("product_id"));
        return new Gson().fromJson(priceMap, Map.class).get("price") + "";
    }
}







