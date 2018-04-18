package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    void save(@Param("info") Map<String, Object> info);

    void update(@Param("info") Map<String, Object> info);
}
