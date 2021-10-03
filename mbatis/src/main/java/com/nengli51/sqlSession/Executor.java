package com.nengli51.sqlSession;

import com.nengli51.config.Configuration;
import com.nengli51.config.MapperStatement;

import java.util.List;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public interface Executor {
    <E> List<E> query(Configuration configuration, MapperStatement mappedStatement, Object... params) throws Exception;
}
