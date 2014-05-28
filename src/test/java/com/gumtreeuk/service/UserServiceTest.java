package com.gumtreeuk.service;

import com.gumtreeuk.entity.Gender;
import com.gumtreeuk.entity.User;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class UserServiceTest {

    private static UserService userService;

    @BeforeClass
    public static void init() {
        userService = new UserService();
    }

    @Test
    public void testFindMaleCount() {
        long malesCount = userService.countByGender(Gender.Male);
        assertThat(malesCount).isEqualTo(3);
    }

    @Test
    public void testFindTheOldestPerson() {
        User actualUser = userService.findTheOldestPerson();
        assertThat(actualUser.name).isEqualTo("Wes Jackson");
    }

    @Test
    public void testDaysBetweenBillAndPaul() {
        long days = userService.getDaysBetween("Bill", "Paul");
        assertThat(days).isEqualTo(2862);
    }

    @Test
    public void testDaysBetweenUnknownUsers() {
        try {
            userService.getDaysBetween("Alice", "Bob");
            fail("Users should not be found in the info data");
        } catch (IllegalArgumentException ex) {
            assertThat(ex).hasMessage("One or two users do not exist in the file");
        }
    }
}
