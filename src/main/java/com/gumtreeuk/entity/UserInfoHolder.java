package com.gumtreeuk.entity;

import com.gumtreeuk.util.DataParser;

import java.util.Collections;
import java.util.List;

public class UserInfoHolder {

    private static final String USER_FILE_NAME = "/AddressBook";
    private static List<User> users;

    public List<User> getUsers() {
        if (users == null) {
           DataParser.UserInfoReader reader = new DataParser.UserInfoReader(USER_FILE_NAME);
            users = Collections.unmodifiableList(reader.readUsers());
        }
        return users;
    }
}
