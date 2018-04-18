package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.returnOrder.ReturnOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ReturnOrderMapper {
    void save(@Param("info") Map<String, Object> info);

    List<ReturnOrder> getList();

    ReturnOrder getById(String rid);
}
