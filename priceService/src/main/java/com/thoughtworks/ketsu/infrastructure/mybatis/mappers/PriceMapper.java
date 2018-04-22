package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.price.Price;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PriceMapper {
    void save(@Param("info") Map<String, Object> info);

    List<Price> getPrice(@Param("pid") String product_id);
}
