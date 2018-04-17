package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.unloadIng.Unloading;
import com.thoughtworks.ketsu.domain.unloadIng.Unloadings;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.UnloadingMapper;

import javax.inject.Inject;
import java.util.Map;

public class UnloadingRepository implements Unloadings {
    @Inject
    UnloadingMapper unloadingMapper;

    @Override
    public void save(Map<String, Object> info) {
        unloadingMapper.save(info);
    }

    @Override
    public Unloading getList() {
        return unloadingMapper.getList();
    }

    @Override
    public Unloading getByid(String uid) {
        return unloadingMapper.getById(uid);
    }
}
