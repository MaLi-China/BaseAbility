package com.nengli51.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nengli51.pojo.Configuration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class XMLConfigBuilder {
    private Configuration configuration;
    private SAXReader saxReader;

    public XMLConfigBuilder() {
        configuration = new Configuration();
        saxReader = new SAXReader();
    }

    public Configuration parseMainConfig(InputStream inputStream) throws DocumentException, PropertyVetoException {
        Document document = saxReader.read(inputStream);
        Element rootElement = document.getRootElement();
        //解析sqlMapConfig.xml, 封装数据到Configuration对象里面
        List<Node> properties = rootElement.selectNodes("//property");
        Properties prop = new Properties();
        //取出属性, 保存value到propertie数据容器中
        for (Node property : properties) {
            String key = ((Element) property).attributeValue("name");
            String value = ((Element) property).getTextTrim();
            prop.setProperty(key, value);
        }
        //封装数据库连接池信息到DataSource中 --> Configuration容器
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl(prop.getProperty("url"));
        dataSource.setDriverClass(prop.getProperty("driver"));
        dataSource.setUser(prop.getProperty("username"));
        dataSource.setPassword(prop.getProperty("password"));
        configuration.setDataSource(dataSource);
        //获取封装Mapper的全路径信息
        List<Node> mappers = rootElement.selectNodes("mapper");
        for (Node mapper : mappers) {
            String path = ((Element) mapper).attributeValue("resource");
            parseMapperConfig(path);
        }
        return configuration;
    }

    public void parseMapperConfig(String path) throws DocumentException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
        Document document = saxReader.read(inputStream);
        Element rootElement = document.getRootElement();
        List<Node> mapper = rootElement.selectNodes("//mapper//*");
        List<Element> list = rootElement.selectNodes("//mapper");

        for (Node node : mapper) {
            Element element = (Element) node;
            String text = element.getTextTrim();
            System.out.println(text);
        }
    }

    @Test
    public void testParseMapperConfig() {
        try {
            this.parseMapperConfig("userMapper.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
