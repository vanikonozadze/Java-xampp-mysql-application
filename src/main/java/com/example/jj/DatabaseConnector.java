package com.example.jj;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bank_account";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch ( Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database.");
        }
    }

}
