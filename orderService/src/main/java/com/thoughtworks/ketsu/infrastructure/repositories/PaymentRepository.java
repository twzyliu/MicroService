package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.payment.Payment;
import com.thoughtworks.ketsu.domain.payment.Payments;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.PaymentMapper;

import javax.inject.Inject;
import java.util.Map;

public class PaymentRepository implements Payments{
    @Inject
    PaymentMapper paymentMapper;

    @Override
    public void save(Map<String, Object> info) {
        paymentMapper.save(info);
    }

    @Override
    public Payment getPayment(String oid) {
        return paymentMapper.getPayment(oid);
    }
}
