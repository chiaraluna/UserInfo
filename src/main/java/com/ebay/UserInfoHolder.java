package com.ebay;

import com.ebay.entity.User;

import java.util.Set;
import java.util.TreeSet;

public class UserInfoHolder {

    private static final String USER_FILE_NAME = "/AddressBook";
    private static Set<User> users = new TreeSet<User>();

    private UserInfoHolder() {}

    public static Set<User> getUsers() {
        if (users == null) {
           UserInfoReader reader = new UserInfoReader(USER_FILE_NAME);
            users = reader.readUsers();
        }
        return users;
    }
}
