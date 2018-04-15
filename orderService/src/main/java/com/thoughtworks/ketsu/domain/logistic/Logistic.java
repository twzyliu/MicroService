package com.thoughtworks.ketsu.domain.logistic;


import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

public class Logistic implements Record {
    private String id;
    private String order_id;
    private String time;
    private String create_time;

    public String getId() {
        return id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getTime() {
        return time;
    }

    public String getCreate_time() {
        return create_time;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return new HashMap(){{
            put("id",id);
            put("order_id",order_id);
            put("time",time);
            put("create_time",create_time);
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }
}
