package com.ebay;

import com.ebay.entity.Gender;
import com.ebay.entity.User;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {

    private static UserService userService;

    @BeforeClass
    public static void init() {
        userService = new UserService();
    }

    @Test
    public void testFindMaleCount() {
        int actualMalesCount = userService.countByGender(Gender.Male);
        assertEquals(3, actualMalesCount);
    }

    @Test
    public void testFindTheOldestMan() {
        User actualUser = userService.findTheOldestMan();
        assertEquals("Wes Jackson", actualUser.name);
    }
}
