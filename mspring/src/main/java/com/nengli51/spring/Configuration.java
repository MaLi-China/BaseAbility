package com.nengli51.spring;

import com.nengli51.beans.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class Configuration {
    //解析配置文件
    private List<String> classes = new ArrayList<>();
    private Map<String, String> keyvalue = new HashMap<>();

    public void parse() {
        InputStream inputStream = Configuration.class.getClassLoader().getResourceAsStream("beans.xml");
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(inputStream);
            Element rootElement = document.getRootElement();
            List<Element> list = rootElement.selectNodes("//bean");
            for (Element element : list) {
                String id = element.attribute("id").getValue();
                String clazz = element.attribute("class").getValue();
                keyvalue.put(id, clazz);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String id) {
        boolean containsKey = keyvalue.containsKey(id);
        Object o = null;
        if (containsKey) {
            try {
                o = Class.forName(keyvalue.get(id)).newInstance();
            } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return o;
    }

    @Test
    public void TestMethod() {
        parse();
        User user = (User) getBean("user");
        System.out.println(user);
    }
}
