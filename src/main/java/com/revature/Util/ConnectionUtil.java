package com.revature.Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil{
public static Connection getConnection() throws Exception{
    try {
        Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e){
        e.printStackTrace();
    }
    String url ="jdbc:postgresql://34.132.250.211/postgres";
    String username ="postgres";
    String password ="password";
    return DriverManager.getConnection(url,username,password);
}
}
