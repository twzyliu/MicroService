package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.order.Orders;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.OrderMapper;

import javax.inject.Inject;
import java.util.Map;

public class OrderRepository implements Orders{
    @Inject
    OrderMapper orderMapper;

    @Override
    public void save(Map<String, Object> info) {
        orderMapper.save(info);
    }
}
