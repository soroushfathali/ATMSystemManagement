package org.example.AtmSystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC implements AutoCloseable {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection connection;

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
