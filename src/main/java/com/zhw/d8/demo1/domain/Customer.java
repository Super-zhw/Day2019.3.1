package com.zhw.d8.demo1.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Day2019.3.1
 * com.zhw.d8.demo1.domain
 *
 * @author Zhang Huiwen
 * @time 2019-04-21 下午 3:25
 */
@Data
@Component("Customer")
public class Customer {
    private Integer id;
    private String username;
    private String jobs;
    private String phone;

    public Customer() {
    }

    public Customer(String username, String jobs, String phone) {
        this.username = username;
        this.jobs = jobs;
        this.phone = phone;
    }

    public Customer(Integer id, String username, String jobs, String phone) {
        this.id = id;
        this.username = username;
        this.jobs = jobs;
        this.phone = phone;
    }
}
