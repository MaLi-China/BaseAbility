package com.nengli51.config;

import com.nengli51.pojo.Configuration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class XMLConfigBuilder {
    public static Configuration parse(InputStream inputStream) throws DocumentException {
        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();
        Iterator<Element> properties = rootElement.elementIterator("property");
        Properties configProp = new Properties();
        while (properties.hasNext()) {
            Element element = properties.next();
            String name = element.attribute("name").getValue();
            String value = element.getText();
            configProp.setProperty(name, value);
            System.out.println(name + "--" + value);
        }
        return null;
    }

    @Test
    public void testParse() throws DocumentException {
        InputStream inputStream = XMLConfigBuilder.class.getClassLoader().getResourceAsStream("mbatis-cfg.xml");
        parse(inputStream);
    }
}
