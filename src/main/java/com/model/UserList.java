package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Manages the list of users in the application
 */

public class UserList {
    private static UserList userList;
    private ArrayList<User> users;
    private User currentUser;

    /**
     * Initializes a list of users
     */
    private UserList() {
        this.users = DataLoader.getUsers();
        userList = this;

    }

    // public void createAccount(User user) {
    //     users.add(user);
    // }

    /**
     * Creates a new user account. Gives an error message if username or email is already taken
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param userName the username for the user's account
     * @param email the user's email
     * @param password the password for the user's password
     * @param isAuthor whether or not the user has author privileges
     */
    public boolean createAccount(String firstName, String lastName, String userName, String email, String password, boolean isAuthor) {
        // Username or email cannot already be in use
        for ( int i = 0; i < users.size(); i++ ) {
            String name = users.get(i).getUserName();
            String curr_email = users.get(i).getEmail();
            if( userName.equals(name) || email.equals(curr_email) ) {
                System.out.println("Username or Email is currently in use, please try another.");
                return false;
            }
        }

        // Username cannot start with a digit
        if (Character.isDigit(userName.charAt(0))) {
            System.out.println("Username starts with a number, please try another.");
            return false;
        }

        User user;
        if (isAuthor) {
            user = new Author(UUID.randomUUID(), firstName, lastName, userName, email, password, new ArrayList<UUID>(), new ArrayList<UUID>());
        } else {
            user = new User(UUID.randomUUID(), firstName, lastName, userName, email, password, new ArrayList<UUID>(), false);
        }
        return users.add(user);
    }

    /**
     * Edits a user's information
     * @param user the specified user to edit
     * @return the updated UserList instance
     */
    public UserList editUser(User user) {
        return userList;
    }

    /**
     * Gets a user based off their unique ID
     * @param user the UUID of the specified user
     * @return the corresponding User object, null if no user is found
     */
    public User getUser(UUID user) {
        for ( int i = 0; i < DataLoader.getUsers().size(); i++ ) {
            if ( user.equals(DataLoader.getUsers().get(i).getId()) ) {
                return DataLoader.getUsers().get(i);
            }
        }

        // if no user found
        return null;
    }

    // 
    /**
     * Temporary method to return user based on userName
     * @param userName the user's username
     * @return the corresponding User object, null if no user is found
     */
    public User getUser(String userName) {
        for ( int i = 0; i < DataLoader.getUsers().size(); i++ ) {
            if ( userName.equals(DataLoader.getUsers().get(i).getUserName()) ) {
                return DataLoader.getUsers().get(i);
            }
        }

        // if no user found
        return null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Gets an instance of UserList, creates the instance if it does not exist
     * @return the instance of UserList
     */
    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    /**
     * Saves the list of users
     */
    public void saveUserList() {
        DataWriter.saveUsers();
    }

    /**
     * Allows a user to log in
     * @param userName the user's username
     * @param password the user's password
     * @return the User object if successful, null if login fails
     */
    public User login(String userName, String password) {
        for ( int i = 0; i < users.size(); i++ ) {
            String name = users.get(i).getUserName();
            String pass = users.get(i).getPassword();
            if( userName.equals(name) || password.equals(pass) ) {
                currentUser = users.get(i);
                return users.get(i);
            }

        }

        // if no user found
        return null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    //public void setUserArray() 
}
