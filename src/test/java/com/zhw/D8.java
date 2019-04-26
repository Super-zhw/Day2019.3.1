package com.zhw;

import com.zhw.d8.demo1.domain.Customer;
import com.zhw.d8.demo1.mapper.CustomerMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Day2019.3.1
 * PACKAGE_NAME
 *
 * @author Zhang Huiwen
 * @time 2019-04-21 下午 3:11
 */
public class D8 {

    private ApplicationContext ac = new ClassPathXmlApplicationContext("Beans8.xml");

    @Test
    public void test_isOK() {
        System.out.println("ok");
    }

    @Test
    public void test_MapperScannerConfigurer() {
        CustomerMapper mapper = ac.getBean(CustomerMapper.class);
        System.out.println(mapper);
    }

    @Test
    public void test_insertCustomer() {
        CustomerMapper mapper = ac.getBean(CustomerMapper.class);
        Integer row = mapper.insertCustomer(new Customer("zhw", "", ""));
        if (row >= 1) {
            System.out.println("insert success");
        } else {
            System.out.println("insert failure");
        }
    }

}
