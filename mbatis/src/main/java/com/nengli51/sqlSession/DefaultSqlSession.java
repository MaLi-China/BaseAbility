package com.nengli51.sqlSession;

import com.nengli51.config.Configuration;
import com.nengli51.config.MapperStatement;

import java.util.List;

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
    public <E> List<E> selectList(String statementId, Object... params) {
        MapperStatement mapperStatement = configuration.getMapperStatementMap().get(statementId);
        //调用Excutor进行查询
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        List<E> list = null;
        try {
            list = simpleExecutor.query(configuration, mapperStatement, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
