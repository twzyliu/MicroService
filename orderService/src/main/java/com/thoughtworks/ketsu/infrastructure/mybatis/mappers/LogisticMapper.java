package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.logistic.Logistic;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface LogisticMapper {
    void save(@Param("info") Map<String, Object> info);

    Logistic getLogistic(@Param("oid") String oid);
}
