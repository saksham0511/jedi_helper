package com.flipkart.constant;

public enum Role {
    STUDENT,
    PROFESSOR,
    ADMIN;

    public String getRole() {
        return this.name();
    }

}