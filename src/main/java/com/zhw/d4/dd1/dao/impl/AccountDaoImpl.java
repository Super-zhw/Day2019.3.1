package com.zhw.d4.dd1.dao.impl;

import com.zhw.d4.dd1.dao.AccountDao;
import com.zhw.d4.dd1.pojo.Account;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Day2019.3.1
 * com.zhw.d4.dd1.dao.impl
 * accountDao
 *
 * @author Zhang Huiwen
 * @date 2019-04-07 下午 9:48
 */

@Data
@Scope("prototype")
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AccountDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*
     * 添加用户
     * @param account pojo
     * @return 成功 或 失败
     */
    @Override
    public boolean addAccount(Account account) {
        String sql = "insert account(username, blance) VALUE (?,?)";
        int isOK = jdbcTemplate.update(sql, account.getUsername(), account.getBlance());
        return isOK >= 1;
    }

    /*
     * 更新
     * @param account pojo
     * @return 成功 或 失败
     */
    @Override
    public boolean updateAccount(Account account) {
        String sql = "update account set username = ?,blance = ? where id = ?;";
        int isOK = jdbcTemplate.update(sql, account.getUsername(), account.getBlance(), account.getId());
        return isOK >= 1;
    }

    /*
     * 删除
     * @param account pojo
     * @return 成功 或 失败
     */
    @Override
    public boolean deleteAccount(Account account) {
        String sql = "delete from account where id = ?;";
        int isOK = jdbcTemplate.update(sql, account.getId());
        return isOK >= 1;
    }

    /**
     * 查询 单行
     *
     * @param id id
     * @return 返回对象
     */
    @Override
    public Account findAccountByID(Integer id) {
        String sql = "select * from account where id  = ?;";
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    /**
     * 查询所有对象
     *
     * @return 返回list
     */
    @Override
    public List<Account> findAllAccount_1() {
        String sql = "select * from account;";
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        return jdbcTemplate.query(sql, rowMapper);
    }
}
