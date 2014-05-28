package com.gumtreeuk.service;

import com.gumtreeuk.entity.Gender;
import com.gumtreeuk.entity.User;
import com.gumtreeuk.entity.UserInfoHolder;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private static int MILLIS_IN_A_DAY = 24*60*60*1000;

    private UserInfoHolder userInfoHolder;
    private User theOldest = null;

    public UserService() {
        userInfoHolder = new UserInfoHolder();
    }

    public long countByGender(final Gender gender) {
        return getUsers().parallelStream()
                .filter(user-> user.gender == gender)
                .count();
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

        Comparator<User> sortDobDesc = (u1,  u2) -> Long.compare(u2.dobInMs, u1.dobInMs);
        return users.stream()
                .max(sortDobDesc).get();
    }

    public long getDaysBetween(String userName1, String userName2) {
        List<User> users = getUsers().stream()
                .filter(user -> user.name.startsWith(userName1) || user.name.startsWith(userName2))
                .collect(Collectors.toList());
        if (users.size() < 2) {
            throw new IllegalArgumentException("One or two users do not exist in the file");
        }

        if (users.size() > 2) {
            throw new IllegalArgumentException("One or two users have not unique names");
        }

        return Math.abs(users.get(0).dobInMs - users.get(1).dobInMs) / MILLIS_IN_A_DAY;
    }
}
