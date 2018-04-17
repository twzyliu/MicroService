package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.store.Store;
import com.thoughtworks.ketsu.domain.store.Stores;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.StoreMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Optional.*;

public class StoreRepository implements Stores {
    @Inject
    StoreMapper storeMapper;

    @Override
    public void save(Map<String, Object> info) {
        storeMapper.save(info);
    }

    @Override
    public List<Store> getList() {
        return storeMapper.getList();
    }

    @Override
    public Optional<Store> getById(String sid) {
        Store store = storeMapper.getStore(sid);
        return store == null ? empty() : of(store);
    }
}
