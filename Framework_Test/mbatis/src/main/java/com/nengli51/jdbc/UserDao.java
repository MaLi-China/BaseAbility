package com.nengli51.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * 功能说明：show jdbc's weakness
 * 开发人员：@Author MaLi
 */
public class UserDao {
    @Test
    public void query() {
        Connection connection;
        try {
            //1, 注册Dirver  //hard code
            Class.forName("com.mysql.jdbc.Driver");
            //2, 获取连接, statement
            connection = DriverManager.getConnection("jdbc:mysql:///mybatis?useSSL=false", "root", "root");
            PreparedStatement statement = connection.prepareStatement("select * from user where uid=?");
            //3, 设置参数
            statement.setInt(1, 1); //hard code
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                //4, 结果解析.
                int uid = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String sex = resultSet.getString((3));
                Date birthday = resultSet.getDate("birthday");
                String address = resultSet.getString("address");

                //封装到user中
                User user = new User();
                user.setUid(uid);
                user.setUsername(username);
                user.setSex(sex);
                user.setBirthday(birthday);
                user.setAddress(address);
                System.out.println(user);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
