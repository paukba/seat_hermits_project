package com.model;

// Stuff to be included
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

    // json files cannot be edited
    // Here we collect all objects from the file, do the new stuff, then completely override everything in the file
    public static void saveUsers(){

        // Variables
        /*
        Below is dependant on DataLoader so put this back when that's done
        UserList userList = UserList.getInstance();
        ArrayList<User> users = DataLoader.getUsers();
        */
        ArrayList<User> users = new ArrayList<>(); // This is for testing; Delete later
        users.add(new User("Ashton", "Harris", "ashtonah@email.sc.edu", "ashtonah")); // This is for testing; Delete later
        JSONArray jsonUsers = new JSONArray();

        // Copy all the json's pre-existing objects
        for(int i = 0; i < users.size(); i++)
            jsonUsers.add(getUserJSON(users.get(i)));

        // Write everything + new stuff back to the json
        try(FileWriter file = new FileWriter(USER_FILE_NAME)){
            file.write(jsonUsers.toJSONString());
            file.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    // json stuff definition
    public static JSONObject getUserJson(User user){
        JSONObject userDetails = new JSONObject(); // Make new json object

        // Populate the object with all info extracted from the json
        userDetails.put(USER_ID, user.getId().toString());
        userDetails.put(USER_TYPE, user.getType());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_USER_NAME, user.getUserName());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_FAV_SONGS, user.getFavoriteSongs());
        userDetails.put(USER_MY_SONGS, user.getMySongs());

        return userDetails; // Give it back
    }

    /*
    To be implemented later
    */
    public static void saveSongs(){

    }

    // Stuff for testing
    public static void main(String[] args){
        DataWriter.saveUsers();
    }
}
