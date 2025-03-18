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
        for ( int i = 0; i < DataLoader.getUsers().size(); i++ ) {
            if ( user.equals(DataLoader.getUsers().get(i).getId()) ) {
                return DataLoader.getUsers().get(i);
            }
        }

        // if no user found
        return null;
    }

    public static UserList getInstance() {
        return userList;
    }

    public void saveUserList() {
        DataWriter.saveUsers();
    }

    public User login(String userName, String password) {
        for ( int i = 0; i < users.size(); i++ ) {
            String name = users.get(i).getUserName();
            String pass = users.get(i).getPassword();
            if( userName.equals(name) || password.equals(pass) ) {
                return users.get(i);
            }

        }

        // if no user found
        return null;
    }
}
