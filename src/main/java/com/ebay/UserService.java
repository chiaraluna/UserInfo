package com.ebay;

import com.ebay.entity.Gender;
import com.ebay.entity.User;

import java.util.List;

public class UserService {

    private UserInfoHolder userInfoHolder;

    public UserService() {
        userInfoHolder = new UserInfoHolder();
    }

    public long countByGender(Gender gender) {
        long result = 0;
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
