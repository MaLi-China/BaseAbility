package com.nengli51.sqlSession;

import com.nengli51.config.Configuration;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statementId, Object... params) {
        return null;
    }
}
