package com.nengli51.sqlSession;

import com.nengli51.config.Configuration;
import com.nengli51.config.MainConfigXMLParser;
import org.dom4j.DocumentException;

import java.io.InputStream;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream inputStream) throws DocumentException {
        //1, 解析配置文件
        Configuration mainConfig = MainConfigXMLParser.parse(inputStream);
        //2, 创建SqlSessionFactory的实现类
        SqlSessionFactory sessionFactory = new DefaultSqlSessionFactory(mainConfig);
        return sessionFactory;
    }
}
