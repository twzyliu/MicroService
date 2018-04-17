package com.thoughtworks.ketsu.domain.unloadIng;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

public class Unloading implements Record{
    private String id;
    private String product_id;
    private String quantity;
    private String pay;
    private String create_time;

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return new HashMap(){{
            put("id",id);
            put("product_id",product_id);
            put("quantity",quantity);
            put("pay",pay);
            put("create_time",create_time);
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }

}
