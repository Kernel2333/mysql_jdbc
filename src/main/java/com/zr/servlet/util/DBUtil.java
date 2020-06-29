package com.zr.servlet.util;

import java.sql.*;

public class DBUtil {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wzbc", "root", "123456");
            return connection;
    }

    public static void closeAll(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
