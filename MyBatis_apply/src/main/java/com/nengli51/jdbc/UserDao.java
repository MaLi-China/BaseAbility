package com.nengli51.jdbc;

import com.nengli51.jdbc.entity.User;

import java.sql.*;

/**
 * 功能说明：jdbc的缺点
 * 1, 数据库连接频繁创建释放, 系统资源浪费, 影响系统性能;
 * 2, SQL硬编码在代码中, 未来需求变化, 造成代码不易维护;
 * 3, 使用preparedStatement占位符传参数存在硬编码, where的条件存在变化, 造成代码不易维护;
 * 4, 对结果集解析存在硬编码
 * 开发人员：@Author MaLi
 */
public class UserDao {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8&useSSL=false;", "root", "root");

            preparedStatement = connection.prepareStatement("select * from user where uid=? ");

            preparedStatement.setInt(1, 1);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                int uid = resultSet.getInt("uid");
                String username = resultSet.getString("username");
                String sex = resultSet.getString("sex");
                Date birthday = resultSet.getDate("birthday");
                String address = resultSet.getString("address");
                User user = new User();
                user.setUid(uid);
                user.setUsername(username);
                user.setBirthday(birthday);
                user.setSex(sex);
                user.setAddress(address);
                System.out.println(user);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
