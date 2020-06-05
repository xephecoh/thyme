package com.thymeleaf.springboot.thymeleafdemo.DAO;

import com.thymeleaf.springboot.thymeleafdemo.model.PaymentDeposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDepositRepository extends JpaRepository<PaymentDeposit,Integer> {
}
