package com.thoughtworks.ketsu.domain.returnOrder;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.Map;

public class ReturnOrderItem implements Record{
    private String id;
    private String return_order_id;
    private String product_id;
    private String quantity;
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
