package com.zhw.d3.dd1.demo1;

import lombok.Data;

/**
 * Day2019.3.1
 * com.zhw.d3.dd1.demo1
 * 目标类
 *
 * @author Zhang Huiwen
 * @date 2019-04-02 下午 4:17
 */

@Data
public class UserDaoImpl implements Userdao {
    @Override
    public void addUser() {
        System.out.println("添加用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }
}
