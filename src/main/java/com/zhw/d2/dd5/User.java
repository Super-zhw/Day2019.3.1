package com.zhw.d2.dd5;

import lombok.Data;

import java.util.List;

/**
 * Day2019.3.1
 * com.zhw.d2.dd5
 * 基于XML文档方式装配
 *
 * @author Zhang Huiwen
 * @date 2019-03-13 下午 9:33
 */

@Data
public class User {
    private String username;
    private Integer password;
    private List<String> list;

    public User() {
    }

    public User(String username, Integer password, List<String> list) {
        this.username = username;
        this.password = password;
        this.list = list;
    }
}
