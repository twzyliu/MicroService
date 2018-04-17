package com.thoughtworks.ketsu.domain.inventory;

import java.util.List;
import java.util.Map;

public interface Inventories {
    void save(Map<String, Object> info);

    List<Inventory> getList(String sid);
}
