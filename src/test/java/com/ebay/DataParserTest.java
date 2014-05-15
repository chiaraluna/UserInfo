package com.ebay;

import com.ebay.entity.Gender;
import com.ebay.entity.User;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class DataParserTest {

    @Test
    public void parseStringToUserObject() throws ParseException {
        String userInfoLine = "Bill McKnight, Male, 16/03/77";
        GregorianCalendar dob = new GregorianCalendar(1977, Calendar.MARCH, 16);
        User expectedUser = new User("Bill McKnight", Gender.Male, dob);
        User actualUser = DataParser.parse(userInfoLine);
        assertEquals(expectedUser, actualUser);
    }

    @Test(expected = ParseException.class)
    public void stringContainsLessData() throws ParseException {
        String userInfoLine = "Bill McKnight, 16/03/77";
        DataParser.parse(userInfoLine);
    }
}
