package com.thoughtworks.ketsu.domain.store;

import java.util.List;
import java.util.Map;

public interface Stores {
    void save(Map<String, Object> info);

    List<Store> getList();
}
