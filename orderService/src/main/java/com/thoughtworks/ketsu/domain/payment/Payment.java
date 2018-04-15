package com.thoughtworks.ketsu.domain.payment;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

public class Payment implements Record {
    private String id;
    private String order_id;
    private String pay_type;
    private String creat_time;

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
        return creat_time;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return new HashMap(){{
            put("id", id);
            put("order_id", order_id);
            put("pay_type", pay_type);
            put("creat_time", creat_time);
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }
}
