package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.unloadIng.Unloading;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UnloadingMapper {
    void save(@Param("info") Map<String, Object> info);

    List<Unloading> getList();

    Unloading getById(@Param("uid") String uid);
}
