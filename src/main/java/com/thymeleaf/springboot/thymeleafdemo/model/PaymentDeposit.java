package com.thymeleaf.springboot.thymeleafdemo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="payments_depisits_new")
public class PaymentDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private  PaymentUser user;

    @Column(name="currency")
    private String currency;

    @Column(name="amount")
    private BigDecimal amount;

    @Column(name="new_amount")
    private BigDecimal newAmount;

    @Column(name="fee")
    private BigDecimal fee;

    @Column(name="create_timestamp")
    private long createTimestamp;


    public PaymentDeposit() {
    }


}
