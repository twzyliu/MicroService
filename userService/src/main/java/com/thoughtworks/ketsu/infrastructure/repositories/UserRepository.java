package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.user.User;
import com.thoughtworks.ketsu.domain.user.Users;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.UserMapper;

import javax.inject.Inject;
import java.util.Map;

public class UserRepository implements Users {
    @Inject
    UserMapper userMapper;

    @Override
    public void save(Map<String, Object> info) {
        userMapper.save(info);
    }

    @Override
    public void update(Map<String, Object> info) {
        userMapper.update(info);
    }

    @Override
    public User getById(String uid) {
        return userMapper.getById(uid);
    }
}
