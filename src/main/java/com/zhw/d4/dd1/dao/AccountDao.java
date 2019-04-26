package com.zhw.d4.dd1.dao;

import com.zhw.d4.dd1.pojo.Account;

import java.util.List;

/**
 * Day2019.3.1
 * com.zhw.d4.dd1.dao
 *
 * @author Zhang Huiwen
 * @date 2019-04-07 下午 9:46
 */
public interface AccountDao {
    boolean addAccount(Account account);

    boolean updateAccount(Account account);

    boolean deleteAccount(Account account);

    Account findAccountByID(Integer id);

    List<Account> findAllAccount_1();
}
