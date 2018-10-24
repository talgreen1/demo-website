package com.talgreen.demo.website.server.service;

import com.talgreen.demo.website.server.model.User;
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
        }    catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User[] getAllUsernames() throws SQLException {
        User [] res;
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM users");

        int rowcount = 0;
        if (rs.last()) {
            rowcount = rs.getRow();
            rs.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }

        res = new User [rowcount];

        for (int i=0; i< rowcount; i++){
            rs.next();
            res[i] = new User (rs.getString("username"),
                    rs.getString("password"));
        }
//        while (rs.next()){
//            res += (rs.getString("username")) + "\n";
//        }

        return res;
    }

    public String getUsername(int id) throws SQLException {
        String res = "";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM users where username = '" +id + "'");

        return rs.getString("username");
    }
}
