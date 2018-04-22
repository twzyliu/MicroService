package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.price.Price;
import com.thoughtworks.ketsu.domain.price.Prices;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.PriceMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.*;

public class PriceRepository implements Prices {
    @Inject
    PriceMapper priceMapper;

    @Override
    public void save(Map<String, Object> info) {
        priceMapper.save(info);
    }

    @Override
    public Price getPrice(String product_id) {
        List<Price> priceList = priceMapper.getPrice(product_id);
        if (priceList.size() == 0) {
            return null;
        }
        Price new_price = priceList.get(0);
        for (Price price : priceList) {
            if (parseInt(price.getId()) > parseInt(new_price.getId())) {
                new_price = price;
            }
        }
        return new_price;
    }
}
