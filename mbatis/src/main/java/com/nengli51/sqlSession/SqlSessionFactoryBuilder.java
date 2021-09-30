package com.nengli51.sqlSession;

import com.nengli51.config.Configuration;
import com.nengli51.config.MainConfigXMLParser;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

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
    public SqlSessionFactory build(InputStream mainConfigInputStream) throws DocumentException, PropertyVetoException {
        //1, analysis configuration files
        Configuration configuration = new Configuration();
        configuration.setDataSource(MainConfigXMLParser.parse(mainConfigInputStream));

        //2, build SqlSesssionFactory
        return new DefaultSqlSessionFactory(configuration);
    }
}
