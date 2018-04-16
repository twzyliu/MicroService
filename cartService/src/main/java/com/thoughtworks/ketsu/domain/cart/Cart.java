package com.thoughtworks.ketsu.domain.cart;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

public class Cart implements Record {
    private String id;
    private String user_id;
    private String amount;
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

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return new HashMap() {{
            put("id", id);
            put("user_id", user_id);
            put("amount", amount);
            put("creat_time", creat_time);
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }
}
