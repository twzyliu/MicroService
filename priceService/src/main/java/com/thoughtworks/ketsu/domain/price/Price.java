package com.thoughtworks.ketsu.domain.price;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

public class Price implements Record {
    private String id;
    private String user_id;
    private String product_id;
    private String price;
    private String create_time;

    public String getId() {
        return id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getPrice() {
        return price;
    }

    public String getCreate_time() {
        return create_time;
    }

    public String getUser_id() {
        return user_id;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return new HashMap() {{
            put("id", id);
            put("user_id", user_id);
            put("product_id", product_id);
            put("price", price);
            put("create_time", create_time);
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }
}
