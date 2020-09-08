package com.springboot.springbootcache.dao;

import com.springboot.springbootcache.entity.Payment;

public interface PaymentMapper {
    Payment getPayment(Integer id);
    int updatePayment(Payment payment);
    int deletePayment(Integer id);
}
