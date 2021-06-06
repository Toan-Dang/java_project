package com.company.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionOracle {
    private static final String username = "SYSTEM";
    private static final String Password = "123";
    private static final String Port = "1521";
    private static final String dbxe = "xe";
    private static final String Connect = "jdbc";
    private static final String url = "jdbc:oracle:thin:@localhost:" + Port + ":" + dbxe;
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
             con = DriverManager.getConnection(
                    url, username, Password);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
