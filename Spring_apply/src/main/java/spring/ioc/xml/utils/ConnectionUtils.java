package spring.ioc.xml.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 功能说明：用于获取数据库连接
 * 开发人员：@author MaLi
 */
public class ConnectionUtils {
    private static DataSource dataSource;

    public static Connection getConnection() {

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void setDataSource(DataSource dataSource) {
        ConnectionUtils.dataSource = dataSource;
    }
}
