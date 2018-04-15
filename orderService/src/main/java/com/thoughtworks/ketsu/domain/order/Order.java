package com.thoughtworks.ketsu.domain.order;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Order implements Record {
    private String id;
    private String user_id;
    private String name;
    private String phone;
    private String address;
    private List<OrderItem> order_items;
    private String amount;
    private String create_time;

    public String getId() {
        return id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public List<OrderItem> getOrder_items() {
        return order_items;
    }

    public String getAmount() {
        return amount;
    }

    public String getCreate_time() {
        return create_time;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        List<Map> order_items_json = order_items.stream().map(order_item -> order_item.toRefJson(routes)).collect(toList());
        return new HashMap() {{
            put("id", id);
            put("user_id", user_id);
            put("name", name);
            put("phone", phone);
            put("address", address);
            put("amount", amount);
            put("create_time", create_time);
            put("order_items", order_items_json);
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }
}
