package com.talgreen.demo.website.server.controller;

import com.talgreen.demo.website.server.model.User;
import com.talgreen.demo.website.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class UserController {


    private UserService userService;

    public UserController() {
        userService = new UserService();
    }

    @RequestMapping(path="api/users", produces= MediaType.APPLICATION_JSON_VALUE)
    public User[] main() throws SQLException {
        User[] allUsernames = userService.getAllUsernames();
        System.out.println(allUsernames);
        return allUsernames;
    }

    @RequestMapping(path = "api/users/{id}")
    public User getUser(@PathVariable String id) throws SQLException {
        return userService.getUser(id);
    }

    @RequestMapping(path = "api/users/", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) throws SQLException {
        userService.addUser(user);
    }
    @RequestMapping("/test")
    public String aaa(){
        return "Hello test";
    }


}
