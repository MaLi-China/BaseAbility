package com.nengli51.sqlSession;

import java.util.List;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public interface SqlSession {
    <E> List<E> selectList(String statementId, Object... params);
}
