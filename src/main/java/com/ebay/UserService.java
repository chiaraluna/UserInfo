package com.ebay;

import com.ebay.entity.Gender;
import com.ebay.entity.User;

public class UserService {
    public long countByGender(Gender gender) {
        long result = 0;
        for (User user: UserInfoHolder.getUsers()) {
            if (user.gender == gender) {
                result++;
            }
        }
        return result;
    }
}
