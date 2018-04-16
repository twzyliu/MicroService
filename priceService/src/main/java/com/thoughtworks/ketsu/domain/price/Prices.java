package com.thoughtworks.ketsu.domain.price;

import java.util.Map;

public interface Prices {
    void save(Map<String, Object> info);

    Price getPrice(String product_id);
}
