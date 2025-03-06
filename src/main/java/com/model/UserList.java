package com.model;

import java.util.ArrayList;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users = new ArrayList<User>();

    private UserList() {
        this.users = new ArrayList<User>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public UserList editUser(User user) {
        return userList;
    }

    public User getUser() {
        return new User(null, null, null, null, null, false);
    }

    public static UserList getInstance() {
        return userList;
    }

    public void saveUserList() {
        DataWriter.saveUsers();
    }
}
