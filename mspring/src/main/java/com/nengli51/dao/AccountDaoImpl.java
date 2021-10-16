package com.nengli51.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nengli51.beans.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class AccountDaoImpl implements IAccountDao {
    @Override
    public void updateAccount(Account account) {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("update taccount set amount=? where id = ?");
            statement.setFloat(1, account.getAmount());
            statement.setInt(2, account.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
