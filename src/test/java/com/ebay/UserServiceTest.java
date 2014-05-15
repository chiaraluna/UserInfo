package com.ebay;

import com.ebay.entity.Gender;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {
    @Test
    public void testFindMaleCount() {
        UserService userService = new UserService();
        int actualMalesCount = userService.countByGender(Gender.Male);
        assertEquals(3, actualMalesCount);
    }

}
