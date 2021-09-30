package com.nengli51.sqlSession;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public interface SqlSession {
    /**
     * select one record with the statementId from db,
     *
     * @param statementId unique id represent a specified SQLStatement
     * @param params      SQLParams
     * @param <T>         returnType
     * @return Bean of specified type
     */
    <T> T selectOne(String statementId, Object... params);
}
