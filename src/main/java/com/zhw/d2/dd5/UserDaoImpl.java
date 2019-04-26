package com.zhw.d2.dd5;

import org.springframework.stereotype.Repository;

/**
 * Day2019.3.1
 * com.zhw.d2.dd5
 *
 * @author Zhang Huiwen
 * @date 2019-03-16 下午 3:18
 */

@Repository("userdao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("userdao...save....");
    }
}
