package com.nengli51.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * 功能说明：used to parsing main configuration file
 * 开发人员：@author MaLi
 */
public class MainConfigXMLParser {
    /**
     * parse the MainConfigurationFile, package the attributes into DataSource
     *
     * @param mainConfigInputStream represent the inputStream of MainConfigurationFile
     * @return DataSource
     * @throws DocumentException     Document parsing Exception
     * @throws PropertyVetoException Property attribute Exception
     */
    public static DataSource parse(InputStream mainConfigInputStream) throws DocumentException, PropertyVetoException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(mainConfigInputStream);
        Element rootElement = document.getRootElement();
        List<Element> properties = rootElement.selectNodes("//property");
        Properties prop = new Properties();
        for (Element property : properties) {
            String name = property.attribute("name").getValue();
            String value = property.attribute("value").getValue();
            prop.setProperty(name, value);
        }
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(prop.getProperty("driver"));
        dataSource.setJdbcUrl(prop.getProperty("url"));
        dataSource.setUser(prop.getProperty("username"));
        dataSource.setPassword(prop.getProperty("password"));
        // ** parse MapperStatementXmlFile
        return dataSource;
    }
}
