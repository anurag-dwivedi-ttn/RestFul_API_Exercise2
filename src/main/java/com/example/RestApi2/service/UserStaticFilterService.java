package com.example.RestApi2.service;

import com.example.RestApi2.models.UserStaticFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserStaticFilterService {
    private final List<UserStaticFilter> users = new ArrayList<>();

    public UserStaticFilterService() {
        users.add(new UserStaticFilter(1, "Anurag Dwivedi", "anurag@email.com", "abcdef12"));
        users.add(new UserStaticFilter(2, "Rohit Kumar", "rohit@email.com", "abcdef13"));
        users.add(new UserStaticFilter(3, "Anant Pandey", "anant@email.com", "abcdef14"));
    }

    public List<UserStaticFilter> getAllUsers() {
        return users;
    }
}
