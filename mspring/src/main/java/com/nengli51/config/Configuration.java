package com.nengli51.config;

import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class Configuration {
    private static Map<String, Object> container = new HashMap<>();

    /**
     * 解析配置文件, 得到id:object
     *
     * @param cfgFilePath
     * @return
     * @throws DocumentException
     */
    public static Map<String, Object> parse(String cfgFilePath) throws DocumentException {
        //1, parse cfgFile
        Element rootElement = getRootElement(cfgFilePath);
        //创建Bean
        generateBean(rootElement);
        //注入value属性
        injectProperties(rootElement);
        return container;
    }

    /**
     * 获取配置文件的rootElement, 备用
     *
     * @param cfgFilePath 配置文件地址
     * @return Element
     * @throws DocumentException
     */
    private static Element getRootElement(String cfgFilePath) throws DocumentException {
        Element rootElement;
        SAXReader reader = new SAXReader();
        InputStream in = Configuration.class.getClassLoader().getResourceAsStream(cfgFilePath);
        Document document = reader.read(in);
        rootElement = document.getRootElement();
        return rootElement;
    }

    /**
     * 注入属性
     *
     * @param rootElement 根标签
     */
    private static void injectProperties(Element rootElement) {
        List<Element> properties = rootElement.selectNodes("//property");

        for (Element property : properties) {
            String propName = property.attribute("name").getValue();
            Attribute value = property.attribute("value");

            Attribute ref = property.attribute("ref");

            String beanId = property.getParent().attribute("id").getValue();
            Object bean = container.get(beanId);
            try {
                //使用BeanUtils注入属性
                if (value != null) {
                    String propValue = value.getValue();
                    BeanUtils.setProperty(bean, propName, propValue);
                } else if (ref != null) {
                    String propRef = ref.getValue();
                    Object refBean = container.get(propRef);
                    BeanUtils.setProperty(bean, propName, refBean);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 生成Bean
     *
     * @param rootElement 根标签
     */
    private static void generateBean(Element rootElement) {
        List<Element> beanList = rootElement.selectNodes("//bean");
        for (Element bean : beanList) {
            String id = bean.attribute("id").getValue();
            String clazz = bean.attribute("class").getValue();
            Object beanInstance = generateBean(clazz);
            container.put(id, beanInstance);
        }
    }

    //反射创建Bean
    private static Object generateBean(String clazz) {
        Object beanInstance = null;
        try {
            Constructor<?> constructor = Class.forName(clazz).getConstructor();
            beanInstance = constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beanInstance;
    }
}
