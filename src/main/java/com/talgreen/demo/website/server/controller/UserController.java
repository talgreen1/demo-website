package com.talgreen.demo.website.server.controller;

import com.talgreen.demo.website.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class UserController {


    private UserService userService;

    public UserController() {
        userService = new UserService();
    }

    @RequestMapping("/")
    public String main() throws SQLException {
        return userService.getAllUsernames();
//        return "Hello";



    }


}
