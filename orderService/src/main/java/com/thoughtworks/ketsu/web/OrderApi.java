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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.alibaba.fastjson.JSON.toJSONString;
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
        int amount = 0;
        for (Map order_item : order_items) {
            String price = getPrice(order_item);
            if ("-1".equals(price)) {
                return status(400).build();
            }
            amount += parseInt(price) * parseInt(order_item.get("quantity") + "");
        }
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
        List<Map> uploadings = order_items.stream().map(order_item -> new HashMap() {{
            put("product_id", order_item.get("product_id"));
            put("quantity", order_item.get("quantity"));
            put("pay", "0");
        }}).collect(toList());
        String unloadings_str = toJSONString(uploadings);
        Map uploadingMap = new HashMap() {{
            put("upploading", unloadings_str);
        }};
        String uploading_json = new Gson().toJson(uploadingMap, Map.class);
        doPost("http://" + host + ":" + port + "/unloadings", uploading_json);
    }

    private String getPrice(Map order_item) {
        String host = getenv().getOrDefault("PRICE_SERVICE_HOST", "127.0.0.1");
        String port = getenv().getOrDefault("PRICE_SERVICE_PORT", "23333");
        String priceMap = doGet("http://" + host + ":" + port + "/prices?product_id=" + order_item.get("product_id"));
        Map price_map = new Gson().fromJson(priceMap, Map.class);
        return priceMap.contains("price") ?
                price_map.get("price") + "" :
                "-1";
    }
}







