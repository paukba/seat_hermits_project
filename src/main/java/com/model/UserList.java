package com.model;

import java.util.ArrayList;
import java.util.UUID;

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

    public User getUser(UUID user) {
        return new User(null, null, null, null, null, null, false);
    }

    public static UserList getInstance() {
        return userList;
    }

    public void saveUserList() {
        DataWriter.saveUsers();
    }
}
