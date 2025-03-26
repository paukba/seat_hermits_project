package com.model;

import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users;

    private UserList() {
        this.users = DataLoader.getUsers();
        userList = this;

    }

    // public void createAccount(User user) {
    //     users.add(user);
    // }

    public void createAccount(String firstName, String lastName, String userName, String email, String password, boolean isAuthor) {
        for ( int i = 0; i < users.size(); i++ ) {
            String name = users.get(i).getUserName();
            String curr_email = users.get(i).getEmail();
            if( userName.equals(name) || email.equals(curr_email) ) {
                System.out.println("Username or Email is currently in use, please try another.");
                return;
            }
        }

        User user;
        if (isAuthor) {
            user = new Author(UUID.randomUUID(), firstName, lastName, userName, email, password, new ArrayList<UUID>(), new ArrayList<UUID>());
        } else {
            user = new User(UUID.randomUUID(), firstName, lastName, userName, email, password, new ArrayList<UUID>(), false);
        }
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

    // temp method to return user based on userName
    public User getUser(String userName) {
        for ( int i = 0; i < DataLoader.getUsers().size(); i++ ) {
            if ( userName.equals(DataLoader.getUsers().get(i).getUserName()) ) {
                return DataLoader.getUsers().get(i);
            }
        }

        // if no user found
        return null;
    }

    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
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

    //public void setUserArray() 
}
