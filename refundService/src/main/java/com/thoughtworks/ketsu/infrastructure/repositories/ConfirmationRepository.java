package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.confirmation.Confirmation;
import com.thoughtworks.ketsu.domain.confirmation.Confirmations;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.ConfirmationMapper;

import javax.inject.Inject;
import java.util.Map;

public class ConfirmationRepository implements Confirmations {
    @Inject
    ConfirmationMapper confirmationMapper;

    @Override
    public void save(Map<String, Object> info) {
        confirmationMapper.save(info);
    }

    @Override
    public Confirmation getConfirmation(String rid) {
        return confirmationMapper.getConfirmation(rid);
    }
}
