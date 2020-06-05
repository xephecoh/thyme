package com.thymeleaf.springboot.thymeleafdemo.Service;

import com.thymeleaf.springboot.thymeleafdemo.model.PaymentDeposit;
import com.thymeleaf.springboot.thymeleafdemo.model.PaymentUser;

import java.util.List;

public interface DepositService {
    public List<PaymentDeposit> findAll();
    public PaymentDeposit findById(int id);
    public void save(PaymentDeposit user);
    public void delete(int id);
}

