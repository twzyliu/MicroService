package com.thoughtworks.ketsu.domain.returnOrder;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReturnOrder implements Record {
    private String id;
    private String order_id;
    private String amount;
    private List<ReturnOrderItem> return_order_items;
    private String create_time;

    public String getId() {
        return id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getAmount() {
        return amount;
    }

    public List<ReturnOrderItem> getReturn_order_items() {
        return return_order_items;
    }

    public String getCreate_time() {
        return create_time;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        List<Map> items_map = return_order_items.stream().map(item -> item.toRefJson(routes)).collect(Collectors.toList());
        return new HashMap(){{
            put("id",id);
            put("order_id",order_id);
            put("amount",amount);
            put("return_order_items",items_map);
            put("create_time",create_time);
        }};
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return toRefJson(routes);
    }
}
