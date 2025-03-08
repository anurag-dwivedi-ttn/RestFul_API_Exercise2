package com.example.RestApi2.service;

import com.example.RestApi2.models.UserEnhanced;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserEnhancedService {
    private final Map<String, UserEnhanced> userEnhancedMap = new HashMap<>();

    public UserEnhancedService() {
        userEnhancedMap.put("1", new UserEnhanced("1", "Anurag", "Dwivedi", 22, "abcdef12"));
        userEnhancedMap.put("2", new UserEnhanced("2", "Rohit", "Kumar", 23, "abcdef13"));
        userEnhancedMap.put("3", new UserEnhanced("3", "Anant", "Pandey", 24, "abcdef14"));

    }


    public void createUser(UserEnhanced user) {
        userEnhancedMap.put(user.getId(), user);
    }

    public List<UserEnhanced> getUsers() {
        return new ArrayList<>(userEnhancedMap.values());
    }

    public UserEnhanced getUserById(String id) {
        return userEnhancedMap.get(id);
    }

    public void updateUser(String id, UserEnhanced user) {
        userEnhancedMap.put(id, user);
    }

    public void deleteUser(String id) {
        userEnhancedMap.remove(id);
    }
}
