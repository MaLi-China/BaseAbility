package spring.ioc.xml.dao;


import spring.ioc.xml.bean.Account;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class AccountDaoImpl implements IAccountDao {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void updateAccount(Account account) {
        Connection connection;
        try {
            connection = dataSource.getConnection();
            String sql = "update t_account set amount=? where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setFloat(1, account.getAmount());
            statement.setInt(2, account.getId());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account findAccount(Integer accountId) {
        Connection connection;
        Account account = null;
        try {
            connection = dataSource.getConnection();
            String sql = "select * from t_account where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setFloat(1, accountId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                float amount = resultSet.getFloat("amount");
                account = new Account(accountId, amount);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}
