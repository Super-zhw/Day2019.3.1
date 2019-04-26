package com.zhw;

import com.zhw.d6.demo1.domain.Customer;
import com.zhw.d6.demo1.util.MyBatisTools;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Day2019.3.1
 * PACKAGE_NAME
 *
 * @author Zhang Huiwen
 * @time 2019-04-14 下午 5:06
 */
public class D6 {

    // 没有与Spring整合的MyBaits
    public static class Demo1 {


        // 通过id查找
        @Test
        public void test_findByID() {
            MyBatisTools myBatisTools = new MyBatisTools();
            myBatisTools.openSqlSession(false);
            // 执行映射文件中sql语句，并返回结果
            Customer customer = myBatisTools.getSqlSession().selectOne("com.zhw.d6.demo1.dao.CustomerDao.findByID", 1);
            System.out.println(customer);
            myBatisTools.close();
        }

        // 通过username查找
        @Test
        public void test_findByUsername() {
            MyBatisTools myBatisTools = new MyBatisTools();
            myBatisTools.openSqlSession(false);
            // 执行映射文件中sql语句，并返回结果
            Customer customer = myBatisTools.getSqlSession().selectOne("com.zhw.d6.demo1.dao.CustomerDao.findByUsername", "zh");
            System.out.println(customer);
            myBatisTools.close();
        }


        // 通过job查找
        @Test
        public void test_findByJob() {
            MyBatisTools myBatisTools = new MyBatisTools();
            myBatisTools.openSqlSession(false);
            // 执行映射文件中sql语句，并返回结果
            Customer customer = myBatisTools.getSqlSession().selectOne("com.zhw.d6.demo1.dao.CustomerDao.findByJob", "javaEE");
            System.out.println(customer);
            myBatisTools.close();
        }

        // 通过phone查找
        @Test
        public void test_findByPhone() {
            MyBatisTools myBatisTools = new MyBatisTools();
            myBatisTools.openSqlSession(false);
            // 执行映射文件中sql语句，并返回结果
            Customer customer = myBatisTools.getSqlSession().selectOne("com.zhw.d6.demo1.dao.CustomerDao.findByPhone", "456");
            System.out.println(customer);
            myBatisTools.close();
        }

        // 查找所有用户
        @Test
        public void test_findAll() {
            MyBatisTools myBatisTools = new MyBatisTools();
            myBatisTools.openSqlSession(false);
            // 执行映射文件中sql语句，并返回结果
            List<Customer> list = myBatisTools.getSqlSession().selectList("com.zhw.d6.demo1.dao.CustomerDao.findAll");
            for (Customer customer : list) {
                System.out.println(customer);
            }
            myBatisTools.close();
        }

        // 添加客户
        @Test
        public void test_insertCustomer() {
            MyBatisTools myBatisTools = new MyBatisTools();
            myBatisTools.openSqlSession(true);
            // 执行映射文件中sql语句，并返回结果
            int isOk = myBatisTools.getSqlSession().insert("com.zhw.d6.demo1.dao.CustomerDao.insertCustomer", new Customer(0, "lzh", "advance curd", "120"));
            if (isOk >= 1) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }
            myBatisTools.close();
        }

        // 修改客户 （id 是不能了修改的！）
        @Test
        public void test_updateCustomer() {
            MyBatisTools myBatisTools = new MyBatisTools();
            myBatisTools.openSqlSession(true);
            // 执行映射文件中sql语句，并返回结果
            int isOk = myBatisTools.getSqlSession().update("com.zhw.d6.demo1.dao.CustomerDao.updateCustomer", new Customer(3, "lzhsss", "advance curd", "120ssss"));
            if (isOk >= 1) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
            myBatisTools.close();
        }

        // 删除客户 （通过id删除）
        @Test
        public void test_deleteCustomer() {
            MyBatisTools myBatisTools = new MyBatisTools();
            myBatisTools.openSqlSession(true);
            // 执行映射文件中sql语句，并返回结果
            int isOk = myBatisTools.getSqlSession().delete("com.zhw.d6.demo1.dao.CustomerDao.deleteCustomer", 3);
            if (isOk >= 1) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
            myBatisTools.close();
        }

    }

    // 与Spring整合的MyBatis
    public static class Demo2 {
        private static ApplicationContext ac = new ClassPathXmlApplicationContext("Beans6.xml");
        private static SqlSessionTemplate sst = (SqlSessionTemplate) ac.getBean("sqlSessionTemplate");

        @Test
        public void test_javaIsOk() {
            System.out.println("ok");
        }

        // 通过id查找
        @Test
        public void test_findByID() {
            // 执行映射文件中sql语句，并返回结果
            Customer customer = sst.selectOne("com.zhw.d6.demo1.dao.CustomerDao.findByID", 1);
            System.out.println(customer);
        }

        // 通过username查找
        @Test
        public void test_findByUsername() {
            // 执行映射文件中sql语句，并返回结果
            Customer customer = sst.selectOne("com.zhw.d6.demo1.dao.CustomerDao.findByUsername", "zh");
            System.out.println(customer);

        }

        // 通过job查找
        @Test
        public void test_findByJob() {
            // 执行映射文件中sql语句，并返回结果
            Customer customer = sst.selectOne("com.zhw.d6.demo1.dao.CustomerDao.findByJob", "javaEE");
            System.out.println(customer);
        }

        // 通过phone查找
        @Test
        public void test_findByPhone() {
            // 执行映射文件中sql语句，并返回结果
            Customer customer = sst.selectOne("com.zhw.d6.demo1.dao.CustomerDao.findByPhone", "456");
            System.out.println(customer);
        }

        // 查找所有用户
        @Test
        public void test_findAll() {
            // 执行映射文件中sql语句，并返回结果
            List<Customer> list = sst.selectList("com.zhw.d6.demo1.dao.CustomerDao.findAll");
            for (Customer customer : list) {
                System.out.println(customer);
            }
        }

        // 添加客户
        @Test
        public void test_insertCustomer() {
            // 执行映射文件中sql语句，并返回结果
            int isOk = sst.insert("com.zhw.d6.demo1.dao.CustomerDao.insertCustomer", new Customer(0, "lzh", "advance curd", "120"));
            if (isOk >= 1) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }
        }

        // 修改客户 （id 是不能了修改的！）
        @Test
        public void test_updateCustomer() {
            // 执行映射文件中sql语句，并返回结果
            int isOk = sst.update("com.zhw.d6.demo1.dao.CustomerDao.updateCustomer", new Customer(3, "lzhsss", "advance curd", "120ssss"));
            if (isOk >= 1) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
        }

        // 删除客户 （通过id删除）
        @Test
        public void test_deleteCustomer() {
            // 执行映射文件中sql语句，并返回结果
            int isOk = sst.delete("com.zhw.d6.demo1.dao.CustomerDao.deleteCustomer", 15);
            if (isOk >= 1) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
//            int x = 10 / 0;
            isOk = sst.delete("com.zhw.d6.demo1.dao.CustomerDao.deleteCustomer", 13);
            if (isOk >= 1) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        }
    }


    @Test
    public void test_javaIsOk() {
        System.out.println("ok");
    }
}
