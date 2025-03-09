package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
    private static Connection con = null;
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/wanderstay";
        String user = "root";
        String pass = "Shivam@123";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    return con;
    }
}
