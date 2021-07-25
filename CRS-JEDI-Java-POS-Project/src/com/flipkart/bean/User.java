package com.flipkart.bean;

import com.flipkart.constant.Role;

public class User {
    private int userId;
    private Role role;
    private String name;
    private String password;
    private String email;
    private String address;

    public User( Role role, String name, String password, String email, String address) {
        this.userId = userId;
        this.role = role;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
    }
    public User(){

    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
