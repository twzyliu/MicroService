package com.thoughtworks.ketsu.domain.payment;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

public class Payment implements Record {
    private String id;
    private String user_id;
    private String order_id;
    private String pay_type;
    private String create_time;

    public String getId() {
        return id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getPay_type() {
        return pay_type;
    }

    public String getCreat_time() {
        return create_time;
    }

    public String getUser_id() {
        return user_id;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return new HashMap(){{
            put("id", id);
            put("user_id", user_id);
            put("order_id", order_id);
            put("pay_type", pay_type);
            put("create_time", create_time);
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }
}
