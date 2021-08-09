package com.nengli51.sqlSession;

import com.nengli51.config.XMLConfigBuilder;
import com.nengli51.io.Resources;
import com.nengli51.pojo.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * 功能说明：解析配置文件, 创建SqlMapFactory
 * 开发人员：@Author MaLi
 */
public class SqlMapFactoryBuilder {
    public SqlMapFactory build(String path) throws DocumentException, PropertyVetoException {
        //功能1: 解析两类配置文件, 并将解析结果保存到Configuration类中
        InputStream inputStream = Resources.loadConfig(path);
        Configuration configuration = new XMLConfigBuilder().parseMainConfig(inputStream);

        //功能2: 创建SqlSessionFactory工场对象(, )用于生产SqlSession)

        return null;
    }
}
