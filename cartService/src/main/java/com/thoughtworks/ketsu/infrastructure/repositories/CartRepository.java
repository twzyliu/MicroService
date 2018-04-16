package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.cart.Cart;
import com.thoughtworks.ketsu.domain.cart.Carts;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.CartMapper;

import javax.inject.Inject;
import java.util.Map;

public class CartRepository implements Carts{
    @Inject
    CartMapper cartMapper;

    @Override
    public void save(Map<String, Object> info) {
        cartMapper.save(info);
    }

    @Override
    public Cart getCart(String cid) {
        return cartMapper.getCart(cid);
    }
}
