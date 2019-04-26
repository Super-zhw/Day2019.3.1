package com.zhw;

import com.zhw.d5.demo1.dao.AccountDao;
import com.zhw.d5.demo1.pojo.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Day2019.3.1
 * PACKAGE_NAME
 *
 * @author Zhang Huiwen
 * @date 2019-04-09 上午 10:22
 */
public class D5 {

    private ApplicationContext ac = new ClassPathXmlApplicationContext("Beans5.xml");

    @Test
    public void test_HelloWorld() {
        System.out.println("HelloWorld");
    }

    @Test
    public void test_转账() {
        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);
        if (accountDao.transfer(new Account(1), new Account(2), 10D)) {
            System.out.println("转账成功");
        } else {
            System.out.println("转账失败");
        }
    }

    @Test
    public void test_xml事务() {
        /*
            基于xml声明式事务
         */
        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);
        if (accountDao.transfer(new Account(1), new Account(2), 10D)) {
            System.out.println("转账成功");
        } else {
            System.out.println("转账失败");
        }
    }

    @Test
    public void test_annotation事务() {
        /*
            基于annotation事务
         */
        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);
        if (accountDao.transfer(new Account(1), new Account(2), 10D)) {
            System.out.println("转账成功");
        } else {
            System.out.println("转账失败");
        }

    }

}
