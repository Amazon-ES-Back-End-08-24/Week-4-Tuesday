package org.ironhack.enums;

import org.ironhack.classes.Role;

public class User {
    private int age;
    private String username;
    private String password;
    private Role userRole;

    public User(int age, String username, String password, Role userRole) {
        this.age = age;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }
}
