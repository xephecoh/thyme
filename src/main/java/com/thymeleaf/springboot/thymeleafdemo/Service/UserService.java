package com.thymeleaf.springboot.thymeleafdemo.Service;

import com.thymeleaf.springboot.thymeleafdemo.model.PaymentUser;
import java.util.List;

public interface UserService {
    public List<PaymentUser> findAll();
    public PaymentUser findById(int id);
    public void save(PaymentUser user);
    public void delete(int id);
    public List<PaymentUser> findByEmail(String email);
}
