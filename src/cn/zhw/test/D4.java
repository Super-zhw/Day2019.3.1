import cn.zhw.d4.dd1.dao.AccountDao;
import cn.zhw.d4.dd1.dao.BaseDao;
import cn.zhw.d4.dd1.pojo.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Day2019.3.1
 * PACKAGE_NAME
 *
 * @author Zhang Huiwen
 * @date 2019-04-05 下午 10:06
 */
public class D4 {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("cn/zhw/d4/Beans4.xml");

    @Test
    public void test_connection(){
        /*
         * 测试数据库的连接
         */
        DataSource dataSource = (DataSource) ac.getBean("dataSource");
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test_dao(){
        /*
         * 测试 jdbc模板
         */
        BaseDao dao = (BaseDao) ac.getBean("baseDao");
        System.out.println(dao.getJdbcTemplate());
    }

    @Test
    public void test_CreateTable(){
        /* 测试创建表
         *
         */
        BaseDao dao = (BaseDao) ac.getBean("baseDao");
        dao.createTable();
    }

    @Test
    public void test_dropTable(){
        /*
         * 测试删除表
         */
        BaseDao dao = (BaseDao) ac.getBean("baseDao");
        dao.dropTable();
    }

    @Test
    public void test_addAccount(){
        /*
            测试添加Account
         */
        AccountDao dao = ac.getBean("accountDao",AccountDao.class);
        Account account = new Account();
        account.setBlance(100D);
        account.setUsername("zhw");
        if (dao.addAccount(account)) {
            System.out.println("添加成功！ " + account);
        }
        else {
            System.out.println("添加失败！ " + account);
        }
        account.setUsername("sc");
        account.setBlance(95D);
        if (dao.addAccount(account)) {
            System.out.println("添加成功！ " + account);
        }
        else {
            System.out.println("添加失败！ " + account);
        }
        account.setUsername("zjf");
        account.setBlance(90D);
        if (dao.addAccount(account)) {
            System.out.println("添加成功！ " + account);
        }
        else {
            System.out.println("添加失败！ " + account);
        }
    }

    @Test
    public void test_updateAccount(){
        /*
            测试更新Account
         */
        AccountDao dao = ac.getBean("accountDao",AccountDao.class);
        Account account = new Account();
        account.setId(1);
        account.setUsername("Super-zhw");
        account.setBlance(200.1D);
        if (dao.updateAccount(account)) {
            System.out.println("修改成功！ " + account);
        }
        else {
            System.out.println("修改失败！ " + account);
        }
    }

    @Test
    public void test_deleteAccount(){
        /*
            测试删除Account
         */
        AccountDao dao = ac.getBean("accountDao",AccountDao.class);
        Account account = new Account();
        account.setId(3);
        if (dao.deleteAccount(account)) {
            System.out.println("删除成功！ " + account);
        }
        else {
            System.out.println("删除失败！ " + account);
        }
    }

    @Test
    public void test_queryByID_1(){
        /*
            测试  查询 findAccountByID
         */
        AccountDao dao = ac.getBean("accountDao",AccountDao.class);
        System.out.println(dao.findAccountByID(1));
    }
    
    @Test
    public void test_queryAll_1(){
        /*
            测试 查询findAllAccount_1
         */
        AccountDao dao = ac.getBean("accountDao",AccountDao.class);
        for (Account account : dao.findAllAccount_1()) {
            System.out.println(account);
        }
    }

}
