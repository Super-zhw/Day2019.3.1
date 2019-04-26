package com.zhw.d6.demo1.domain;


import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Data
@Alias("customer")
@Component("customer")
public class Customer {

    private Integer id;
    private String username;
    private String job;
    private String phone;

    public Customer(Integer id, String username, String job, String phone) {
        this.id = id;
        this.username = username;
        this.job = job;
        this.phone = phone;
    }

    public Customer() {
    }
}
