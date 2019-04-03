package cn.zhw.d2.dd2;

import cn.zhw.d2.dd1.Bean1;
import cn.zhw.d2.dd1.Bean2;
import lombok.extern.java.Log;

/**
 * Day2019.3.1
 * cn.zhw.d2.dd2
 *
 * @author Zhang Huiwen
 * @date 2019-03-01 下午 3:30
 */

@Log
class MyBean2Factory {

    // 使用自己的工厂创建Bean1实例
    public static Bean1 createBean() {
        log.info("静态工厂");
        return new Bean1();
    }
}
