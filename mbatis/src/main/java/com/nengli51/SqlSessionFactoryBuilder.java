package com.nengli51;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 功能说明：Be used to analysis configuration files and build SqlSessionFactory
 * 开发人员：@author MaLi
 */
public class SqlSessionFactoryBuilder {

    /**
     * 1, analysis configuration files
     * 2, build a SqlSessionFactory
     *
     * @param mainConfigInputStream Main configuration file's inputstream
     * @return SqlSessionFactory
     */
    public SqlSessionFactory build(InputStream mainConfigInputStream) throws DocumentException {
        //1, analysis configuration files
        SAXReader reader = new SAXReader();
        Document document = reader.read(mainConfigInputStream);
        Element rootElement = document.getRootElement();
        List<Element> properties = rootElement.selectNodes("//property");
        for (Element property : properties) {
            String name = property.attribute("name").getValue();
            String value = property.attribute("value").getValue();
            System.out.println(name + " --> " + value);
        }

        //2, build SqlSesssionFactory
        return null;
    }

    @Test
    public void test_build() {


    }
}
