package com.gumtreeuk.util;

import com.gumtreeuk.entity.Gender;
import com.gumtreeuk.entity.User;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class DataParserTest {

    @Test
    public void testParsingStringToUserObjectMale() throws ParseException {
        String userInfoLine = "Bill McKnight, Male, 16/03/77";
        GregorianCalendar dob = new GregorianCalendar(1977, Calendar.MARCH, 16);
        User expectedUser = new User("Bill McKnight", Gender.Male, dob.getTime().getTime());
        User actualUser = DataParser.parse(userInfoLine);
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void testParsingStringToUserObjectFemale() throws ParseException {
        String userInfoLine = "Bella McKnight, Female, 16/03/77";
        GregorianCalendar dob = new GregorianCalendar(1977, Calendar.MARCH, 16);
        User expectedUser = new User("Bella McKnight", Gender.Female, dob.getTime().getTime());
        User actualUser = DataParser.parse(userInfoLine);
        assertEquals(expectedUser, actualUser);
    }


    @Test(expected = ParseException.class)
    public void testStringContainsLessData() throws ParseException {
        String userInfoLine = "Bill McKnight, 16/03/77";
        DataParser.parse(userInfoLine);
    }

    @Test(expected = ParseException.class)
    public void testStringContainsWrongGender() throws ParseException {
        String userInfoLine = "Bill McKnight, Somebody, 16/03/77";
        DataParser.parse(userInfoLine);
    }
}
