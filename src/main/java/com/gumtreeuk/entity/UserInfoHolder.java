package com.gumtreeuk.entity;

import com.gumtreeuk.util.DataParser;
import com.gumtreeuk.util.UserInfoReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

public class UserInfoHolder {

    private static final String USER_FILE_NAME = "/AddressBook";
    private static List<User> users;

    public List<User> getUsers() {
        if (users == null) {

            InputStream inputStream = UserInfoReader.class.getResourceAsStream(USER_FILE_NAME);
            Reader fileReader = new BufferedReader(new InputStreamReader(inputStream));
            UserInfoReader userReader = new UserInfoReader(fileReader, new DataParser());
            users = Collections.unmodifiableList(userReader.readUsers());
        }
        return users;
    }
}
