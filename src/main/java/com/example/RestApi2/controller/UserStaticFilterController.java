package com.example.RestApi2.controller;

import com.example.RestApi2.models.UserStaticFilter;
import com.example.RestApi2.service.UserStaticFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class UserStaticFilterController {

    private final UserStaticFilterService userService;

    @Autowired
    public UserStaticFilterController(UserStaticFilterService userService) {
        this.userService = userService;
    }

    @GetMapping("/userStaticFilter")
    public List<UserStaticFilter> getAllUsers() {
        return userService.getAllUsers();
    }
}
