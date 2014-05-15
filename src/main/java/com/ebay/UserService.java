package com.ebay;

import com.ebay.entity.Gender;
import com.ebay.entity.User;

import java.util.GregorianCalendar;
import java.util.List;

public class UserService {

    private UserInfoHolder userInfoHolder;
    private User theOldest = null;

    public UserService() {
        userInfoHolder = new UserInfoHolder();
    }

    public int countByGender(Gender gender) {
        int result = 0;
        for (User user: getUsers()) {
            if (user.gender == gender) {
                result++;
            }
        }
        return result;
    }

    public List<User> getUsers() {
        return userInfoHolder.getUsers();
    }

    public User findTheOldestMan() {
        if (theOldest != null) {
            return theOldest;
        }

        List<User> users = getUsers();

        if (users == null || users.isEmpty()) {
            return null;
        }

        theOldest = users.get(0);
        for (User user: getUsers()) {
            if (user.dob.before(theOldest.dob)) {
                theOldest = user;
            }
        }
        return theOldest;
    }
}
