package com.thymeleaf.springboot.thymeleafdemo.Service;

import com.thymeleaf.springboot.thymeleafdemo.model.PaymentUser;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public List<PaymentUser> findAll();
    public PaymentUser findById(int id);
    public void save(PaymentUser user);
    public void delete(int id);
}
