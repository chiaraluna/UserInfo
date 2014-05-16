package com.gumtreeuk.service;

import com.gumtreeuk.entity.Gender;
import com.gumtreeuk.entity.User;
import com.gumtreeuk.entity.UserInfoHolder;

import java.util.Iterator;
import java.util.List;

public class UserService {

    private static int MILLIS_IN_A_DAY = 24*60*60*1000;

    private UserInfoHolder userInfoHolder;
    private User theOldest = null;

    public UserService() {
        userInfoHolder = new UserInfoHolder();
    }

    public int countByGender(Gender gender) {
        int result = 0;
        for (User user : getUsers()) {
            if (user.gender == gender) {
                result++;
            }
        }
        return result;
    }

    public List<User> getUsers() {
        return userInfoHolder.getUsers();
    }

    public User findTheOldestPerson() {
        if (theOldest != null) {
            return theOldest;
        }

        List<User> users = getUsers();

        if (users == null || users.isEmpty()) {
            return null;
        }

        theOldest = users.get(0);
        for (User user : getUsers()) {
            if (user.dobInMs <theOldest.dobInMs) {
                theOldest = user;
            }
        }
        return theOldest;
    }

    public long getDaysBetween(String userName1, String userName2) {
        User user1 = null;
        User user2 = null;
        Iterator<User> iter = getUsers().iterator();
        while (iter.hasNext() && (user1 == null || user2 == null)) {
            User user = iter.next();
            if (user.name.startsWith(userName1)) {
                user1 = user;
            } else if (user.name.startsWith(userName2)) {
                user2 = user;
            }
        }
        if (user1 == null || user2 == null) {
            throw new IllegalArgumentException("One or two users do not exist in the file");
        }

        return Math.abs(user1.dobInMs - user2.dobInMs) / MILLIS_IN_A_DAY;
    }
}
