package com.thoughtworks.ketsu.domain.inventory;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

public class InventoryItem implements Record{
    private String id;
    private String inventory_id;
    private String product_id;
    private String quantity;
    private String create_time;

    public String getId() {
        return id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getCreate_time() {
        return create_time;
    }

    public String getInventory_id() {
        return inventory_id;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return new HashMap(){{
            put("id",id);
            put("inventory_id",inventory_id);
            put("product_id",product_id);
            put("quantity",quantity);
            put("create_time",create_time);
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }
}
