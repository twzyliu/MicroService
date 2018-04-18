package com.thoughtworks.ketsu.domain.returnOrder;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.List;
import java.util.Map;

public class ReturnOrder implements Record {
    private String id;
    private String order_id;
    private String amount;
    private List<ReturnOrderItem> return_order_items;
    private String create_time;

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return null;
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return null;
    }
}
