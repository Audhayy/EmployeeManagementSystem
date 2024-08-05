package com.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
*<p>
*This helper class is used to create and close connections.
*</p>
*/
public class DatabaseConnection {
    static Connection connection;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/managementsystem";
    private static final String USERNAME = "root"; // Replace with your MySQL username
    private static final String PASSWORD = ""; // Replace with your MySQL password if any

    public static Connection getConnection() throws SQLException {
        try {
            if(connection == null ||connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed");
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}