package com.zhw;

import com.zhw.d2.dd1.Bean1;
import com.zhw.d2.dd1.Bean2;
import com.zhw.d2.dd5.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Day2019.3.1
 * com.zhw.test
 *
 * @author Zhang Huiwen
 * @date 2019-03-01 下午 3:12
 */
public class D2 {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/zhw/d2/beans2.xml");


    @Test
    public void test_1() {
        System.out.println("ok");
    }

    @Test
    public void test_2() {
        // 构造方式注入
        Bean2 bean2 = (Bean2) applicationContext.getBean("bean2");
        bean2.say();

    }

    @Test
    public void test_4() {
        // 实例化工厂方式实例化
        Bean1 bean1 = (Bean1) applicationContext.getBean("bean3");
        bean1.say();
    }

    @Test
    public void test_3() {
        // 静态工厂方式实例化
        Bean1 bean1 = (Bean1) applicationContext.getBean("myBean1Factory");
        bean1.say();
    }

    @Test
    public void test_5() {
        // 单例模式 singleton
        System.out.println(applicationContext.getBean("scope"));
        System.out.println(applicationContext.getBean("scope"));
    }

    @Test
    public void test_6() {
        // 原型模式 prototype
        System.out.println(applicationContext.getBean("prototype"));
        System.out.println(applicationContext.getBean("prototype"));
    }

    @Test
    public void test_7() {
        // XML文档装配
        System.out.println(applicationContext.getBean("user1"));
        System.out.println(applicationContext.getBean("user2"));
    }

    @Test
    public void test_8() {
        // 注解装配
        UserController userController = (UserController) applicationContext.getBean("userController");
        userController.save();
    }

    @Test
    public void test_9() {
        // 自动装配
        UserController userController = (UserController) applicationContext.getBean("controller");
        userController.save();
    }

}
