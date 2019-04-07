package cn.zhw.d4.dd1.dao;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Day2019.3.1
 * cn.zhw.d4.dd1.dao
 *
 * @author Zhang Huiwen
 * @date 2019-04-05 下午 10:07
 */
@Scope(value = "prototype")
@Repository(value = "baseDao")
@Data
public class BaseDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTable(){
        String sql = "create table account(id int primary key auto_increment,username varchar(20),blance double);";
        jdbcTemplate.execute(sql);
        System.out.println("Account表创建成功！");
    }

    public void dropTable(){
        String sql = "drop table account; ";
        jdbcTemplate.execute(sql);
        System.out.println("Account表删除成功");
    }

}
