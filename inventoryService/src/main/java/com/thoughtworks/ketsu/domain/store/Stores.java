package com.thoughtworks.ketsu.domain.store;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Stores {
    void save(Map<String, Object> info);

    List<Store> getList();

    Optional<Store> getById(String sid);

    void update(Map<String, Object> info);
}
