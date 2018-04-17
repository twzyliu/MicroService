package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.inventory.Inventory;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface InventoryMapper {
    void save(@Param("info") Map<String, Object> info);

    List<Inventory> getList(@Param("sid") String sid);
}
