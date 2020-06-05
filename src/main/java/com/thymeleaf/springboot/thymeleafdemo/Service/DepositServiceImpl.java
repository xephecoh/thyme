package com.thymeleaf.springboot.thymeleafdemo.Service;

import com.thymeleaf.springboot.thymeleafdemo.DAO.PaymentDepositRepository;
import com.thymeleaf.springboot.thymeleafdemo.model.PaymentDeposit;
import com.thymeleaf.springboot.thymeleafdemo.model.PaymentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositServiceImpl implements DepositService {
    @Autowired
    PaymentDepositRepository repository;

    @Override
    public List<PaymentDeposit> findAll() {
        return repository.findAll();
    }

    @Override
    public PaymentDeposit findById(int id) {
        return null;
    }


    @Override
    public void save(PaymentDeposit deposit) {

    }

    @Override
    public void delete(int id) {

    }

}
