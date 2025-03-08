package com.example.RestApi2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Q4)- Static Filtering: Ignores "password" field globally for all APIs
@JsonIgnoreProperties({"password"})
public class UserStaticFilter {
    private int id;
    private String name;

    // Static Filtering: Ignores this field globally
    @JsonIgnore
    private String email;

    private String password;

    public UserStaticFilter(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
