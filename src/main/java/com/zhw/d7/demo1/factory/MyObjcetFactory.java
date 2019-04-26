package com.zhw.d7.demo1.factory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

/**
 * Day2019.3.1
 * com.zhw.d7.demo1.factory
 *
 * @author Zhang Huiwen
 * @time 2019-04-21 上午 10:03
 */
public class MyObjcetFactory extends DefaultObjectFactory {
    @Override
    public <T> T create(Class<T> type) {
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
