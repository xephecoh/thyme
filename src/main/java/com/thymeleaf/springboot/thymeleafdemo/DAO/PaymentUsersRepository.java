package com.thymeleaf.springboot.thymeleafdemo.DAO;

import com.thymeleaf.springboot.thymeleafdemo.model.PaymentUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentUsersRepository extends JpaRepository<PaymentUser,Integer> {

}
