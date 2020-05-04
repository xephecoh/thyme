package com.thymeleaf.springboot.thymeleafdemo.model;

import javax.persistence.*;
import java.util.Date;

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
    private long createTimestamp;

    private Date date;

    public PaymentUser() {
    }

    public PaymentUser(int id,String uuid,String email,long createTimeStamp) {
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

    public long getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
