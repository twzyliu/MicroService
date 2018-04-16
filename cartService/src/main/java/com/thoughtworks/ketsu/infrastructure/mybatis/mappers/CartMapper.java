package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.cart.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface CartMapper {
    void save(@Param("info") Map<String, Object> info);

    Cart getCart(@Param("cid") String cid);
}
