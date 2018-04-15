package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.logistic.Logistics;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.LogisticMapper;

import javax.inject.Inject;
import java.util.Map;

public class LogisticRepository implements Logistics{
    @Inject
    LogisticMapper logisticMapper;

    @Override
    public void save(Map<String, Object> info) {
        logisticMapper.save(info);
    }
}
