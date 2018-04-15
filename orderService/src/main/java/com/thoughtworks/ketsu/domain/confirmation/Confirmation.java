package com.thoughtworks.ketsu.domain.confirmation;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

public class Confirmation implements Record {
    private String id;
    private String order_id;
    private String recipient;
    private String create_time;

    public String getId() {
        return id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getCreate_time() {
        return create_time;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return new HashMap(){{
            put("id", id);
            put("order_id", order_id);
            put("recipient", recipient);
            put("create_time", create_time);
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }
}
