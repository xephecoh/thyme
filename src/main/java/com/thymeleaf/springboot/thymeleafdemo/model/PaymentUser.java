package com.thymeleaf.springboot.thymeleafdemo.model;

import javax.persistence.*;

@Entity
@Table(name="payments_users")
public class PaymentUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="user_uuid")
    private String uuid;

    @Column(name="email")
    private String email;

    @Column(name="create_timestamp")
    private int createTimestamp;

    public PaymentUser() {
    }

    public PaymentUser(int id,String uuid,String email,int createTimeStamp) {
        this.id=id;
        this.uuid=uuid;
        this.email=email;
        this.createTimestamp=createTimeStamp;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(int createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
