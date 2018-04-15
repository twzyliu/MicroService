package com.thoughtworks.ketsu.domain.product;

import java.util.List;
import java.util.Map;

public interface Products {
    void save(Map<String, Object> info);

    List<Product> getProducts();

    Product getById(String pid);

    void update(Map<String, Object> info);
}
