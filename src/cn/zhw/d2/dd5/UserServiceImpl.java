package cn.zhw.d2.dd5;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Day2019.3.1
 * cn.zhw.d2.dd5
 *
 * @author Zhang Huiwen
 * @date 2019-03-16 下午 3:21
 */


@Repository("userservice")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public void save() {
        this.userDao.save();
        System.out.println("userservice....save....");
    }

    public UserServiceImpl setUserDao(UserDao userDao) {
        this.userDao = userDao;
        return this;
    }
}
