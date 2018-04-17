package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.store.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StoreMapper {
    void save(@Param("info") Map<String, Object> info);

    List<Store> getList();
}
