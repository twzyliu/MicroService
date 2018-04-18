package com.thoughtworks.ketsu.domain.returnOrder;

import java.util.List;
import java.util.Map;

public interface ReturnOrders {
    void save(Map<String, Object> info);

    List<ReturnOrder> getList();
}
