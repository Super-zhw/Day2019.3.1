package com.zhw.d6.demo1.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Day2019.4.13
 * com.zhw.util
 * 工具类
 *
 * @author Zhang Huiwen
 * @time 2019-04-13 下午 9:36
 */
public class MyBatisTools {
    private static SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession = null;

    static {
        try {
            // 读取配置文件
            Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config-d6.xml");
            // SqlSession工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openSqlSession(Boolean flag) {
        // 打开会话 ， 并设置是否 启用事务
        sqlSession = sqlSessionFactory.openSession(flag);
    }

    public SqlSession getSqlSession() {
        // 获得会话
        return sqlSession;
    }

    public void close() {
        // 关闭会话，并且置空
        sqlSession.close();
        sqlSession = null;
    }
}
