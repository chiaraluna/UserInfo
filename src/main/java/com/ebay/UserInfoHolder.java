package com.ebay;

import com.ebay.entity.User;

import java.util.Collections;
import java.util.Set;

public class UserInfoHolder {

    private static final String USER_FILE_NAME = "/AddressBook";
    private static Set<User> users;

    private UserInfoHolder() {}

    public static Set<User> getUsers() {
        if (users == null) {
           UserInfoReader reader = new UserInfoReader(USER_FILE_NAME);
            users = Collections.unmodifiableSet(reader.readUsers());
        }
        return users;
    }
}
