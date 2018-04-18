package com.thoughtworks.ketsu.domain.returnOrder;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ReturnOrders {
    void save(Map<String, Object> info);

    List<ReturnOrder> getList();

    Optional<ReturnOrder> getById(String rid);
}
