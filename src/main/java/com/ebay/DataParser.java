package com.ebay;

import com.ebay.entity.Gender;
import com.ebay.entity.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataParser {

    private static final String DELIM = ", ";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

    public static User parse(String userInfoLine) throws ParseException {
        String[] data = userInfoLine.split(DELIM);
        validate(data);
        String name = data[0];
        Gender gender = null;
        try {
            gender = Gender.valueOf(data[1]);
        } catch (IllegalArgumentException ex) {
            throw new ParseException("gender should be Male or Female", 1);
        }
        Date date = dateFormat.parse(data[2]);
        GregorianCalendar dob = new GregorianCalendar(1900 + date.getYear(), date.getMonth(), date.getDate());
        return new User(name, gender, dob);
    }

    private static void validate(String[] data) throws ParseException {
        if (data.length < 2) {
            throw new ParseException("There is not enough parameters", data.length -1);
        }
    }
}
