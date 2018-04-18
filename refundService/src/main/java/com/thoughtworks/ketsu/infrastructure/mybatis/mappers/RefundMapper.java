package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.refund.Refund;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface RefundMapper {
    void save(@Param("info") Map<String, Object> info);

    Refund getRefund(String rid);
}
