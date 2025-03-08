package com.example.RestApi2.controller;


import com.example.RestApi2.models.User;
import com.example.RestApi2.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
//Ques-2

@RestController
public class UserController {
    private UserService service;
    private final MessageSource messageSource;

    @Autowired
    public UserController(UserService service, MessageSource messageSource) {
        this.service = service;
        this.messageSource=messageSource;
    }
   //Q1)- Internationalization Add support for Internationalization in your application allowing messages to be shown in English, German and Swedish, keeping English as default.
    @GetMapping("/greet")
    @Operation(summary = "Greeting", description = "Greeting in three languages by default is English")
    public String greetUser(@RequestParam(defaultValue = "en") String lang) {
        Locale locale = switch (lang) {
            case "de" -> Locale.GERMAN;
            case "sv" -> new Locale("sv");
            default -> Locale.ENGLISH;
        };
        return messageSource.getMessage("hello.message", null, locale);
    }
    //Q2)- Content Negotiation A) Create POST Method to create user details which can accept XML for user creation. B) Create GET Method to fetch the list of users in XML format.
    // POST Method : this accepts XML Input
    // will create user with password
    @PostMapping(path = "/user",consumes = MediaType.APPLICATION_XML_VALUE)
    @Operation(summary = "Save the user", description = "Creates a new user and saves it in the system.")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        service.createUser(user);
        return new ResponseEntity<>("User created successfully!", HttpStatus.CREATED);
    }

    // GET Method : this returns XML Response
    // will not give password as we used @JsonIgnore
    @GetMapping(path = "/user", produces = MediaType.APPLICATION_XML_VALUE)
    @Operation(summary = "Get list of users", description = "Fetches all users stored in the system.")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
    }

    // will not give password as we used @JsonIgnore
    @GetMapping(path = "user/{id}")
    @Operation(summary = "Get user by ID", description = "Fetches a specific user based on their ID.")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    @Operation(summary = "Update a user", description = "Updates an existing user with new details.")
    public ResponseEntity<String> createUser(@PathVariable String id ,@RequestBody User user) {
        service.updateUser(id,user);
        return new ResponseEntity<>("User Updated successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    @Operation(summary = "Delete a user", description = "Removes a user from the system based on their ID.")
    public ResponseEntity<String> deleateUser(@PathVariable String id ) {
        service.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully!", HttpStatus.OK);
    }

}
