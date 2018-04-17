package com.thoughtworks.ketsu.domain.inventory;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Inventory implements Record {
    private String id;
    private String store_id;
    private List<InventoryItem> inventory_items;
    private String create_time;

    public String getId() {
        return id;
    }

    public String getStore_id() {
        return store_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public List<InventoryItem> getInventory_items() {
        return inventory_items;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        List<Map> inventory_items_json = inventory_items.stream().map(item -> item.toRefJson(routes)).collect(Collectors.toList());
        return new HashMap() {{
            put("id", id);
            put("store_id", store_id);
            put("create_time", create_time);
            put("inventory_items", inventory_items_json);
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }
}
