package com.thoughtworks.ketsu.domain.cart;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Cart implements Record {
    private String id;
    private String user_id;
    private String amount;
    private List<CartItem> cart_items;
    private String creat_time;

    public String getId() {
        return id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getAmount() {
        return amount;
    }

    public String getCreat_time() {
        return creat_time;
    }

    public List<CartItem> getCart_items() {
        return cart_items;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        List<Map> cart_items_json = cart_items.stream().map(order_item -> order_item.toRefJson(routes)).collect(toList());
        return new HashMap() {{
            put("id", id);
            put("user_id", user_id);
            put("amount", amount);
            put("creat_time", creat_time);
            put("cart_items", cart_items_json);
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }
}
