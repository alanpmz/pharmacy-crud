package com.alanpmz.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection () throws SQLException {
        String url = "jdbc:mysql://localhost:3306/estoque_farmacia";
        String username = "root";
        String password = "meds";

        return DriverManager.getConnection(url,username, password);
    }
}
