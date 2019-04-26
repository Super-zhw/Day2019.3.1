package com.zhw.d3.dd1.demo2;

import lombok.Data;

/**
 * Day2019.3.1
 * com.zhw.d3.dd1.demo2
 * 目标类
 *
 * @author Zhang Huiwen
 * @date 2019-04-02 下午 6:02
 */
@Data
public class UserDao {
    public void addUser() {
        System.out.println("添加用户 --CGLIB");
    }

    public void delUser() {
        System.out.println("删除用户 --CGLIB");
    }
}
