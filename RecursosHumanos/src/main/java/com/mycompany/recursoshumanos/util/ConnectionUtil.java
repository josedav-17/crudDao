package com.mycompany.recursoshumanos.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {
    
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/Taller";
        String user = "postgres";
        String password = "12345d";
        return DriverManager.getConnection(url, user, password);
    }

}

