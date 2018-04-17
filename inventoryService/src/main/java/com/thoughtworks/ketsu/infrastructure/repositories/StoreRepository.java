package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.store.Stores;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.StoreMapper;

import javax.inject.Inject;
import java.util.Map;

public class StoreRepository implements Stores {
    @Inject
    StoreMapper storeMapper;

    @Override
    public void save(Map<String, Object> info) {
        storeMapper.save(info);
    }
}
