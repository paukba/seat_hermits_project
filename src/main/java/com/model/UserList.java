package com.model;

import java.util.ArrayList;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users;

    private UserList() {
        
    }

    public void addUser(User user) {
        
    }

    public UserList editUser(User user) {
        return userList;
    }

    public User getUser() {
        return new User();
    }

    public static UserList getInstance() {
        return new UserList();
    }

    public void saveUserList() {
        
    }
}
