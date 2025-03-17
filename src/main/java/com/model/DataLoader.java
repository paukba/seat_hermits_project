package com.model;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

public class DataLoader extends DataConstants {
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < usersJSON.size(); i++) {
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                UUID id = UUID.fromString((String)userJSON.get(USER_ID));
                String type = (String)userJSON.get(USER_TYPE);
                String firstName = (String)userJSON.get(USER_FIRST_NAME);
                String lastName = (String)userJSON.get(USER_LAST_NAME);
                String userName = (String)userJSON.get(USER_USER_NAME);
                String email = (String)userJSON.get(USER_EMAIL);
                String password = (String)userJSON.get(USER_PASSWORD);
                JSONArray favSongs = (JSONArray)userJSON.get(USER_FAV_SONGS);
                JSONArray mySongs = (JSONArray)userJSON.get(USER_MY_SONGS);

                if (type == "a") {
                    Users.add(new Author(id, firstName, lastName, userName, email, password, favSongs, mySongs));
                }
                else {
                    Users.add(new User(id, firstName, lastName, userName, email, password, favSongs));
                }
            }
            return users;
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
}
