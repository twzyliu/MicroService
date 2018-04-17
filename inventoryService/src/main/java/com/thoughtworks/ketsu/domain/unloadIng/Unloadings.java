package com.thoughtworks.ketsu.domain.unloadIng;

import java.util.Map;

public interface Unloadings {
    void save(Map<String, Object> info);

    Unloading getList();
}
