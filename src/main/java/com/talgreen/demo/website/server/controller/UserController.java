package com.talgreen.demo.website.server.controller;

import com.talgreen.demo.website.server.model.User;
import com.talgreen.demo.website.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class UserController {


    private UserService userService;

    public UserController() {
        userService = new UserService();
    }

    @RequestMapping(path="/", produces= MediaType.APPLICATION_JSON_VALUE)
    public User[] main() throws SQLException {
        System.out.println("ssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        User[] allUsernames = userService.getAllUsernames();
        System.out.println(allUsernames);
        return allUsernames;
//        return "Hello";



    }


}
