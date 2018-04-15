package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.order.Order;
import com.thoughtworks.ketsu.domain.order.Orders;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.OrderMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class OrderRepository implements Orders{
    @Inject
    OrderMapper orderMapper;

    @Override
    public void save(Map<String, Object> info) {
        orderMapper.save(info);
    }

    @Override
    public List<Order> getOrders() {
        return orderMapper.getOrders();
    }
}
