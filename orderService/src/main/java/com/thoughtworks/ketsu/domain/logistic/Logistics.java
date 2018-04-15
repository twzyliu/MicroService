package com.thoughtworks.ketsu.domain.logistic;

import java.util.Map;
import java.util.Optional;

public interface Logistics {
    void save(Map<String, Object> info);

    Optional<Logistic> getLogistic(String oid);
}
