package com.ebay;

import com.ebay.entity.Gender;
import com.ebay.entity.User;

import java.util.List;

public class UserService {

    private UserInfoHolder userInfoHolder;

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
}
