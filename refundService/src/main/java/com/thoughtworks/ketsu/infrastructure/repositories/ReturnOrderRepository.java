package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.returnOrder.ReturnOrder;
import com.thoughtworks.ketsu.domain.returnOrder.ReturnOrders;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.ReturnOrderMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class ReturnOrderRepository implements ReturnOrders {
    @Inject
    ReturnOrderMapper returnOrderMapper;

    @Override
    public void save(Map<String, Object> info) {
        returnOrderMapper.save(info);
    }

    @Override
    public List<ReturnOrder> getList() {
        return returnOrderMapper.getList();
    }

    @Override
    public ReturnOrder getById(String rid) {
        return returnOrderMapper.getById(rid);
    }
}
