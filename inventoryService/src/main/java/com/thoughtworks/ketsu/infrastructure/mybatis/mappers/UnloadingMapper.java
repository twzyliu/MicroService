package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.unloadIng.Unloading;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UnloadingMapper {
    void save(@Param("info") Map<String, Object> info);

    Unloading getList();
}
