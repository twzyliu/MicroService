package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.refund.Refund;
import com.thoughtworks.ketsu.domain.refund.Refunds;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.RefundMapper;

import javax.inject.Inject;
import java.util.Map;

public class RefundRepository implements Refunds {
    @Inject
    RefundMapper refundMapper;

    @Override
    public void save(Map<String, Object> info) {
        refundMapper.save(info);
    }

    @Override
    public Refund getRefund(String rid) {
        return refundMapper.getRefund(rid);
    }
}
