package com.example.RestApi2.service;

import com.example.RestApi2.models.UserDynamicFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Q3)- Filtering
@Service
public class UserDynamicFilterService {
    private final Map<String, UserDynamicFilter> userMap = new HashMap<>();

    public UserDynamicFilterService() {
        userMap.put("1", new UserDynamicFilter(1,"Anurag Dwivedi","abcdef12"));
        userMap.put("2", new UserDynamicFilter(2, "Rohit Kumar", "abcdef13"));
        userMap.put("3", new UserDynamicFilter(3, "Ananat Pandey", "abcdef14"));
    }
    public List<UserDynamicFilter> getUsers() {
        return new ArrayList<>(userMap.values());
    }
}
