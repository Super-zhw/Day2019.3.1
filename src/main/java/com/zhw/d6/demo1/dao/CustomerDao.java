package com.zhw.d6.demo1.dao;

import com.zhw.d6.demo1.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Day2019.4.13
 * com.zhw.dao
 * CustomerDao 不需要 实现类 mybatis已经实现了
 *
 * @author Zhang Huiwen
 * @time 2019-04-13 下午 9:10
 */
@Repository("customerDao")
public interface CustomerDao {
    // 通过id查找
    Customer findByID(Integer id);

    // 通过username查找
    Customer findByUsername(String username);

    // 通过job查找
    Customer findByJob(String job);

    // 通过phone查找
    Customer findByPhone(String phone);

    // 查找所有用户
    List<Customer> findAll();

    // 添加客户
    void insertCustomer(Customer customer);

    // 修改客户 （id 是不能了修改的！）
    void updateCustomer(Customer customer);

    // 删除客户 （通过id删除）
    void deleteCustomer(Integer id);

}
