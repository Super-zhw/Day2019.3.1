package com.zhw.d2.dd5;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Day2019.3.1
 * com.zhw.d2.dd5
 *
 * @author Zhang Huiwen
 * @date 2019-03-16 下午 3:28
 */


@Repository("userController")
public class UserController {

    @Resource
    private UserService userService;

    public void save() {
        this.userService.save();
        System.out.println("userController....save.....");
    }

    public UserController setUserService(UserService userService) {
        this.userService = userService;
        return this;
    }
}
