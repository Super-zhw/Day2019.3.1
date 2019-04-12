

import cn.zhw.d1.dd1.dao.UserService;
import cn.zhw.d1.dd1.service.UserServicelmpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Day2019.3.1
 * cn.zhw.test
 *
 * @author Zhang Huiwen
 * @date 2019-03-01 下午 2:35
 */
public class D1 {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cn/zhw/d1/beans1.xml");

    @Test
    public void test_1() {
        System.out.println("ok");
    }

    @Test
    public void test_2() {
        UserService userService = (UserService) applicationContext.getBean("userDaolmpl");
        userService.say();
    }

    @Test
    public void test_3() {
        UserServicelmpl dao = (UserServicelmpl) applicationContext.getBean("userServicelmpl");
        dao.say();
    }


}
