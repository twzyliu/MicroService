package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.returnOrder.ReturnOrder;
import com.thoughtworks.ketsu.domain.returnOrder.ReturnOrders;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.ReturnOrderMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Optional.*;

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
    public Optional<ReturnOrder> getById(String rid) {
        ReturnOrder return_order = returnOrderMapper.getById(rid);
        return return_order == null ? empty() : of(return_order);
    }
}
