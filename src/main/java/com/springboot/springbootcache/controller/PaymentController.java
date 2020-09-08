package com.springboot.springbootcache.controller;

import com.springboot.springbootcache.entity.Payment;
import com.springboot.springbootcache.service.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @RequestMapping("/payment/{id}")
    @ResponseBody
    public String getPayment(@PathVariable("id")Integer id){
        Payment payment = paymentService.getPayment(id);
        System.out.println(payment.getSerial());
        return payment.getSerial();
    }
    @RequestMapping("/update")
    @ResponseBody
    public Payment updatePayment(Payment payment){
        Payment payment1 = paymentService.updatePayment(payment);
        return payment1;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public void deletePayment(Integer id){
        paymentService.deletePayment(id);
    }
}
