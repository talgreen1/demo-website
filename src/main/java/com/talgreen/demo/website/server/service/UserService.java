package com.talgreen.demo.website.server.service;

import org.springframework.stereotype.Service;

import java.sql.*;


public class UserService {

    private String MYSQL_DRIVER_NAME="com.mysql.jdbc.Driver";
    private String MYSQL_URL="jdbc:mysql://localhost:3306/website";
    private String MYSQL_USERNAME="root";
    private String MYSQL_PASSWORD="123456";

    private Connection conn;

    public UserService()  {

        try {
            Class.forName(MYSQL_DRIVER_NAME);
            conn =
                    DriverManager.getConnection(MYSQL_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAllUsernames() throws SQLException {
        String res = "";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM users");

        while (rs.next()){
            res += (rs.getString("username")) + "\n";
        }

        return res;
    }
}
