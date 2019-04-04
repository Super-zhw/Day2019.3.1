package cn.zhw.d3.dd3.demo1.dao.impl;


import cn.zhw.d3.dd3.demo1.dao.UserDao;
import lombok.Data;

/**
 * Day2019.3.1
 * cn.zhw.d3.dd3.demo1.dao
 * 目标类
 * @author Zhang Huiwen
 * @date 2019-04-04 下午 1:10
 */
@Data
public class UserDaoImple implements UserDao {
    @Override
    public void addUser() {
        System.out.println("==========添加用户==========");
    }

    @Override
    public void deleteUser() {
        System.out.println("==========删除用户==========");
    }

    @Override
    public void byZero() {
        System.out.println(1 / 0);
    }
}
