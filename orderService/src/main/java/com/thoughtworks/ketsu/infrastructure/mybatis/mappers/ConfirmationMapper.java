package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ConfirmationMapper {
    void save(@Param("info") Map<String, Object> info);
}