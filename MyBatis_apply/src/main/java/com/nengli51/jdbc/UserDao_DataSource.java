package com.nengli51.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class UserDao_DataSource {
    public static void main(String[] args) {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
