package com.thoughtworks.ketsu.domain.cart;

import java.util.Map;

public interface Carts {
    void save(Map<String, Object> info);

    Cart getCart(String cid);
}
