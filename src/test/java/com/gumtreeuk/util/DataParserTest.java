package com.gumtreeuk.util;

import com.gumtreeuk.entity.Gender;
import com.gumtreeuk.entity.User;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class DataParserTest {

    private static DataParser parser;

    @BeforeClass
    public static void init() {
        parser = new DataParser();
    }

    @Test
    public void testParsingStringToUserObjectMale() throws ParseException {
        String userInfoLine = "Bill McKnight, Male, 16/03/77";
        GregorianCalendar dob = new GregorianCalendar(1977, Calendar.MARCH, 16);
        User expectedUser = new User("Bill McKnight", Gender.Male, dob.getTime().getTime());
        User actualUser = parser.parse(userInfoLine);
        assertThat(actualUser).isEqualTo(expectedUser);
    }

    @Test
    public void testParsingStringToUserObjectFemale() throws ParseException {
        String userInfoLine = "Bella McKnight, Female, 16/03/77";
        GregorianCalendar dob = new GregorianCalendar(1977, Calendar.MARCH, 16);
        User expectedUser = new User("Bella McKnight", Gender.Female, dob.getTime().getTime());
        User actualUser = parser.parse(userInfoLine);
        assertThat(actualUser).isEqualTo(expectedUser);
    }


    @Test
    public void testStringContainsLessData() throws ParseException {
        String userInfoLine = "Bill McKnight, 16/03/77";
        try {
            parser.parse(userInfoLine);
            fail("");
        } catch (ParseException ex) {
            assertThat(ex).hasMessageStartingWith("There is not enough parameters");
        }

    }

    @Test
    public void testStringContainsWrongGender() throws ParseException {
        String userInfoLine = "Bill McKnight, Somebody, 16/03/77";
        try {
            parser.parse(userInfoLine);
            fail("");
        } catch (ParseException ex) {
            assertThat(ex).hasMessageStartingWith("Gender should be Male or Female");
        }
    }
}
