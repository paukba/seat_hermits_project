package com.model;

public class Driver {
    public static void main(String[] args) {
        UserList userList = UserList.getInstance();
        
        // login correct
        User correctLogin = userList.login("iamSpider99", "spiderman2099roolz");

        if (correctLogin != null) {
            System.out.println(correctLogin.getId() + ": " + correctLogin.getFirstName() + " " + correctLogin.getLastName());
        } else {
            System.out.println("Failed to login");
        }



        // login wrong
        User wrongLogin = userList.login("iamSpider", "spidermanroolz");

        if (wrongLogin != null) {
            System.out.println(wrongLogin.getId() + ": " + wrongLogin.getFirstName() + " " + wrongLogin.getLastName());
        } else {
            System.out.println("Failed to login");
        }
    }
}
