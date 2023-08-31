package com.jwt.example.controller;

import com.jwt.example.entities.User;
import com.jwt.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
@Slf4j
public class HomeController {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public List<User> getUser(){
        log.info("getting user");
        return userService.getUsers();
    }
    @GetMapping("/currentuser")
    public String getLoggedInUser(Principal principal){
        return principal.toString();
    }
}
