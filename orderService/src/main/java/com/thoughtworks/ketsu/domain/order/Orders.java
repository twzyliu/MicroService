package com.thoughtworks.ketsu.domain.order;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Orders {
    void save(Map<String, Object> info);

    List<Order> getOrders();

    Optional<Order> getById(String iid);
}
