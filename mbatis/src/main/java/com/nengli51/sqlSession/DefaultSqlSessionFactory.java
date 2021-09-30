package com.nengli51.sqlSession;

import com.nengli51.config.Configuration;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
