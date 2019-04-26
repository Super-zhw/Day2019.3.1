package com.zhw.d5.demo1.dao.impl;

import com.zhw.d5.demo1.dao.AccountDao;
import com.zhw.d5.demo1.pojo.Account;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Day2019.3.1
 * com.zhw.d5.demo1.dao.impl
 * accountDao
 *
 * @author Zhang Huiwen
 * @date 2019-04-09 下午 1:28
 */
@Data
@Transactional
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AccountDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean transfer(Account disburse, Account income, Double money) {
        String sqlDisburse = "update account set blance = blance - ? where id = ?;";
        int isOk1 = jdbcTemplate.update(sqlDisburse, money, disburse.getId());
//        int i = 10 / 0;
        String sqlIncome = "update account set blance = blance + ? where id = ?;";
        int isOk2 = jdbcTemplate.update(sqlIncome, money, income.getId());
        return isOk1 + isOk2 >= 2;
    }
}
