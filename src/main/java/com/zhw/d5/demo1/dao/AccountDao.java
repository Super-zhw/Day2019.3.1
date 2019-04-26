package com.zhw.d5.demo1.dao;

import com.zhw.d5.demo1.pojo.Account;

/**
 * Day2019.3.1
 * com.zhw.d5.demo1.dao
 * AccountDao
 *
 * @author Zhang Huiwen
 * @date 2019-04-09 下午 1:28
 */
public interface AccountDao {
    boolean transfer(Account disburse, Account income, Double money);
}
