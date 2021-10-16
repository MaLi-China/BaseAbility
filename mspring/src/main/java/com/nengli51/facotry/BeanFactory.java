package com.nengli51.facotry;

import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class BeanFactory {
    private static Map<String, Object> container = new HashMap<>();

    public static SpringContext getContext(String path) {
        return SpringContext.getInstance(path);
    }

    //传入一个地址
    public static void parse(String path) {
        System.out.println("Parse Engining is running ...");
        //Step1: 解析配置文件
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream(path);
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(in);
            Element rootElement = document.getRootElement();
            List<Element> elements = rootElement.selectNodes("//bean");
            for (Element element : elements) {
                String id = element.attribute("id").getValue();
                String classStr = element.attribute("class").getValue();
                //Step2: 创建Bean并保存到container中
                Object instance = Class.forName(classStr).newInstance();
                container.put(id, instance);
            }

            List<Element> properties = rootElement.selectNodes("//property");
            for (Element property : properties) {
                String name = property.attribute("name").getValue();
                String value = property.getTextTrim();
                Element bean = property.getParent();
                String beanId = bean.attribute("id").getValue();
                Object instance = container.get(beanId); //需要封装属性的bean
                //使用内省, 封装对象的属性值(不好用, 需要类型转换)
                /*PropertyDescriptor descriptor = new PropertyDescriptor(name, instance.getClass());
                Method writeMethod = descriptor.getWriteMethod();
                Method readMethod = descriptor.getReadMethod();
                writeMethod.invoke(instance, value);*/
                //使用BeanUtils封装属性到Bean中
                BeanUtils.setProperty(instance, name, value);
            }
            for (Element property : properties) {
                //处理ref
                String name = property.attribute("name").getValue();
                String ref = property.attribute("ref").getValue();
                //在container中获取ref的值代表的实例
                Object o = container.get(ref);
                //将ref代表的实例设置到id代表的实例中去
                Element bean = property.getParent();
                String beanId = bean.attribute("id").getValue();
                Object instance = container.get(beanId); //需要封装属性的bean
                BeanUtils.setProperty(instance, name, o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Bean
     *
     * @param beanId
     * @return
     */
    public static Object getBean(String beanId) {
        return container.get(beanId);
    }
}
