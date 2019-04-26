package com.zhw.d1.dd1.dao.impl;

import com.zhw.d1.dd1.dao.UserService;
import lombok.Data;

/**
 * Day2019.3.1
 * com.zhw.d1.dd1.dao.impl
 *
 * @author Zhang Huiwen
 * @date 2019-03-01 下午 2:44
 */

@Data
public class UserDaolmpl implements UserService {
    @Override
    public void say() {
        System.out.println("this is UserDaolmpl ");
    }
}
