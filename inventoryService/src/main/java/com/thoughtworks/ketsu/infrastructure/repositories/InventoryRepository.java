package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.inventory.Inventories;
import com.thoughtworks.ketsu.domain.inventory.Inventory;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.InventoryMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class InventoryRepository implements Inventories {
    @Inject
    InventoryMapper inventoryMapper;

    @Override
    public void save(Map<String, Object> info) {
        inventoryMapper.save(info);
    }

    @Override
    public Inventory getInventory(String sid) {
        List<Inventory> inventoryList = inventoryMapper.getList(sid);
        if (inventoryList.size() == 0) {
            return null;
        }
        Inventory new_inventory = inventoryList.get(0);
        for (Inventory inventory : inventoryList) {
            if (parseInt(inventory.getId()) > parseInt(new_inventory.getId())) {
                new_inventory = inventory;
            }
        }
        return new_inventory;
    }
}
