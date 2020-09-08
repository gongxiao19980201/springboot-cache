package com.springboot.springbootcache.service.Service;

import com.springboot.springbootcache.entity.Payment;

public interface PaymentService {
    Payment getPayment(Integer id);
    Payment updatePayment(Payment payment);
    Payment deletePayment(Integer id);
}
