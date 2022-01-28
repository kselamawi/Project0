package com.revature.Util;

import java.sql.Connection;

public class Driver {
    public static void main(String[] args) {
        try {
           Connection connection = ConnectionUtil.getConnection();
            System.out.println("Connected successfully to  database");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
