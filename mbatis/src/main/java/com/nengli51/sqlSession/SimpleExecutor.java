package com.nengli51.sqlSession;

import com.nengli51.config.Configuration;
import com.nengli51.config.MapperStatement;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class SimpleExecutor implements Executor {
    @Override
    public <E> List<E> query(Configuration configuration, MapperStatement mappedStatement, Object... params) throws Exception {
        //Step1: 查询sql
        Connection connection = configuration.getDataSource().getConnection();
        PreparedStatement statement = connection.prepareStatement(mappedStatement.getSql());
        ResultSet resultSet = statement.executeQuery();
        //Step2: 封装Bean
        String resultType = mappedStatement.getResultType();
        Class<?> resultTypeClass = Class.forName(resultType);

        //获取元数据
        ResultSetMetaData metaData = resultSet.getMetaData();
        List<Object> list = new ArrayList<>();
        while (resultSet.next()) {
            Object o = resultTypeClass.newInstance();
            for (int i = 1; i < metaData.getColumnCount() + 1; i++) {
                String columnName = metaData.getColumnName(i);
                Object columnValue = resultSet.getObject(columnName);
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnName, resultTypeClass);
                Method writeMethod = propertyDescriptor.getWriteMethod();
                writeMethod.invoke(o, columnValue);
            }
            list.add(o);
        }
        return (List<E>) list;
    }
}
