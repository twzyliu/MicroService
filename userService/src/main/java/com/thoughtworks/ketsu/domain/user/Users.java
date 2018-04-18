package com.thoughtworks.ketsu.domain.user;

import java.util.Map;

public interface Users {
    void save(Map<String, Object> info);

    void update(Map<String, Object> info);

    User getById(String uid);
}
