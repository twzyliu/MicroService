package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.price.Price;
import com.thoughtworks.ketsu.domain.price.Prices;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.PriceMapper;

import javax.inject.Inject;
import java.util.Map;

public class PriceRepository implements Prices {
    @Inject
    PriceMapper priceMapper;

    @Override
    public void save(Map<String, Object> info) {
        priceMapper.save(info);
    }

    @Override
    public Price getPrice(String product_id) {
        return priceMapper.getPrice(product_id);
    }
}
