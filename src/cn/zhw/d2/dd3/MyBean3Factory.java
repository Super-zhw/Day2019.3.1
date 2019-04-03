package cn.zhw.d2.dd3;

import cn.zhw.d2.dd1.Bean1;
import lombok.extern.java.Log;

/**
 * Day2019.3.1
 * cn.zhw.d2.dd3
 *
 * @author Zhang Huiwen
 * @date 2019-03-01 下午 4:29
 */
@Log
public class MyBean3Factory {
    public Bean1 createBean() {
        log.info("MyBean3Factory工厂 实例化");
        return new Bean1();
    }
}
