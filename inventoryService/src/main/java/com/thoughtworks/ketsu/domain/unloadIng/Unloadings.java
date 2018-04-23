package com.thoughtworks.ketsu.domain.unloadIng;

import java.util.List;
import java.util.Map;

public interface Unloadings {
    void save(Map<String, Object> info);

    List<Unloading> getList();

    Unloading getByid(String uid);
}
