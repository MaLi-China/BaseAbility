package com.nengli51.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * 功能说明：Used to parse MainConfig.xml
 * 开发人员：@author MaLi
 */
public class MainConfigXMLParser {
    /**
     * parse mainconfig.xml
     *
     * @param inputStream InputStream
     * @return Configuration
     */
    public static Configuration parse(InputStream inputStream) throws DocumentException {

        //Step1: parse Main Confinguration File
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Element rootElement = document.getRootElement();
        List<Element> propertyList = rootElement.selectNodes("//property");
        Properties tmpProperties = new Properties();
        for (Element element : propertyList) {
            String propName = element.attribute("name").getValue();
            String propValue = element.attribute("value").getValue();
            tmpProperties.setProperty(propName, propValue);
        }
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Configuration configuration = new Configuration();
        try {
            dataSource.setDriverClass(tmpProperties.getProperty("driver"));
            dataSource.setJdbcUrl(tmpProperties.getProperty("url"));
            dataSource.setUser(tmpProperties.getProperty("username"));
            dataSource.setPassword(tmpProperties.getProperty("password"));
            configuration.setDataSource(dataSource);

            //Step2: parse Mapper Files
            //<mapper resource="UserMapper.xml"/>
            List<Element> mapperList = rootElement.selectNodes("//mapper");
            for (Element element : mapperList) {
                String mapperFile = element.attribute("resource").getValue();

                //Step3: 解析Mapper映射文件, 并保存到configuration中
                MapperXMLParser.parse(mapperFile, configuration);
            }
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return configuration;
    }
}
