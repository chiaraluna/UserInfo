package com.ebay;

import com.ebay.entity.Gender;
import com.ebay.entity.User;
import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class DataParserTest {

    @Test
    public void parseStringToUserObjectMale() throws ParseException {
        String userInfoLine = "Bill McKnight, Male, 16/03/77";
        GregorianCalendar dob = new GregorianCalendar(1977, Calendar.MARCH, 16);
        User expectedUser = new User("Bill McKnight", Gender.Male, dob);
        User actualUser = DataParser.parse(userInfoLine);
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void parseStringToUserObjectFemale() throws ParseException {
        String userInfoLine = "Bella McKnight, Female, 16/03/77";
        GregorianCalendar dob = new GregorianCalendar(1977, Calendar.MARCH, 16);
        User expectedUser = new User("Bella McKnight", Gender.Female, dob);
        User actualUser = DataParser.parse(userInfoLine);
        assertEquals(expectedUser, actualUser);
    }


    @Test(expected = ParseException.class)
    public void stringContainsLessData() throws ParseException {
        String userInfoLine = "Bill McKnight, 16/03/77";
        DataParser.parse(userInfoLine);
    }

    @Test(expected = ParseException.class)
    public void stringContainsWrongGender() throws ParseException {
        String userInfoLine = "Bill McKnight, Somebody, 16/03/77";
        DataParser.parse(userInfoLine);
    }

    @Test(expected = ParseException.class)
    @Ignore
    public void stringContainsWrongDate() throws ParseException {
        String userInfoLine = "Bill McKnight, Male, 03/16/77";
        DataParser.parse(userInfoLine);
    }
}
