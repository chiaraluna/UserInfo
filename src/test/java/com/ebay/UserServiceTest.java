package com.ebay;

import com.ebay.entity.Gender;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {
    @Test
    public void testTheNumberOfMales() {
        UserService userService = new UserService();

        long maleNumber = userService.countByGender(Gender.Male);
        assertEquals(3, maleNumber);


    }
}
