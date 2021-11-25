package jdbc;

import pojo.User;

import java.sql.*;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class T01_JDBC {
    public static void main(String[] args) {
        //1, 加载驱动
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2, 获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/review?useSSL=false", "root", "root");
            String sql = "select * from user";
            //3, 创建PreparedStatement
            statement = connection.prepareStatement(sql);
            //4, 执行SQL, 获取返回集
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                User user = new User(id, username);
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
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            if (connection != null) {
                                try {
                                    connection.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }


    }
}
