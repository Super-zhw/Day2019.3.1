package com.zhw.d5.demo1.pojo;

import java.lang.Double;
import java.lang.Integer;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("account")
public class Account {

    private Integer id;
    private String username;
    private Double blance;

    public Account() {
    }

    public Account(Integer id) {
        this.id = id;
    }

    public Account(Integer id, String username, Double blance) {
        this.id = id;
        this.username = username;
        this.blance = blance;
    }
}
