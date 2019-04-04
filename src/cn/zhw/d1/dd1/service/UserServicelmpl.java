package cn.zhw.d1.dd1.service;

import cn.zhw.d1.dd1.dao.UserService;
import lombok.Data;
import lombok.extern.java.Log;

/**
 * Day2019.3.1
 * cn.zhw.d1.dd1.dao.impl
 *
 * @author Zhang Huiwen
 * @date 2019-03-01 下午 3:02
 */

@Log
@Data
public class UserServicelmpl {
    private UserService dao;

    //  依赖注入 setting 方式实现
    public void setUserDaolmpl(UserService userDaolmpl) {
        this.dao = userDaolmpl;
    }

    public void say() {
        this.dao.say();
        System.out.println("this is UserServicelmpl");
        log.info("lombok test!");
    }
}
