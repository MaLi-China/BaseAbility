package com.nengli51.property;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 功能说明：读取配置文件, 解析属性信息
 * 开发背景: Kafka的生产者或者消费者代码开头要配置多行设置项, 使用该工具类+配置文件, 做到抽取配置项到文件, 并且一行代码获取所有属性
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/17
 */
public class PropertyUtils {
    /**
     * 获取指定文件的属性
     *
     * @param clazz    使用该工具类的class
     * @param filePath 配置文件路径
     * @return 获取Properties
     */
    public static Properties getProperties(Class clazz, String filePath) {
        Properties properties = null;
        try {
            InputStream inputStream = clazz.getClass().getResourceAsStream(filePath);
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


    /**
     * 获取指定文件, 指定前缀的属性
     *
     * @param clazz    使用该工具类的class
     * @param filePath 配置文件路径
     * @param prefix   属性前缀
     * @return 获取Properties
     */
    public static Properties getProperties(Class clazz, String filePath, String prefix) {
        Properties properties = null;
        try {
            InputStream inputStream = clazz.getClass().getResourceAsStream(filePath);
            properties = new Properties();
            properties.load(inputStream);
            Enumeration<Object> keys = properties.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                if (!key.startsWith(prefix)) {
                    properties.remove(key);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
