package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.inventory.Inventories;
import com.thoughtworks.ketsu.domain.inventory.Inventory;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.InventoryMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class InventoryRepository implements Inventories {
    @Inject
    InventoryMapper inventoryMapper;

    @Override
    public void save(Map<String, Object> info) {
        inventoryMapper.save(info);
    }

    @Override
    public List<Inventory> getList(String sid) {
        return inventoryMapper.getList(sid);
    }
}
