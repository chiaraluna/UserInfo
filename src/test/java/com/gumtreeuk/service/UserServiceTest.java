package com.gumtreeuk.service;

import com.gumtreeuk.entity.Gender;
import com.gumtreeuk.entity.User;
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
    public void testFindTheOldestPerson() {
        User actualUser = userService.findTheOldestPerson();
        assertEquals("Wes Jackson", actualUser.name);
    }

    @Test
    public void testDaysBetweenBillAndPaul() {
        long actualDays = userService.getDaysBetween("Bill", "Paul");
        assertEquals(2862, actualDays);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDaysBetweenUnknownUsers() {
        userService.getDaysBetween("Alice", "Bob");
    }
}
