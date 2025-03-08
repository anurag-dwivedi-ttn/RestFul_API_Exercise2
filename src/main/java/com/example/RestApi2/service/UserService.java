package com.example.RestApi2.service;

import com.example.RestApi2.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, User> userMap = new HashMap<>();

    public UserService() {
        userMap.put("1", new User("1", "Anurag Dwivedi", 22, "abcdef12"));
        userMap.put("2", new User("2", "Rohit Kumar", 23, "abcdef13"));
        userMap.put("3", new User("3", "Ananat Pandey", 25, "abcdef14"));

    }

    public void createUser(User user) {
        userMap.put(user.getId(), user);
    }

    public List<User> getUsers() {
        return new ArrayList<>(userMap.values());
    }

    public User getUserById(String id) {
        return userMap.get(id);
    }

    public void updateUser(String id, User user) {
        userMap.put(id, user);
    }

    public void deleteUser(String id) {
        userMap.remove(id);
    }
}
