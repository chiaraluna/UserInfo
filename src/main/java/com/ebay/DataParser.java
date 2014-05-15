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

    public static User parse(String userInfoLine) {
        String[] data = userInfoLine.split(DELIM);
        String name = data[0];
        Gender gender = Gender.valueOf(data[1]);
        GregorianCalendar dob = null;
        try {
            Date date = dateFormat.parse(data[2]);
            dob = new GregorianCalendar(1900 + date.getYear(), date.getMonth(), date.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new User(name, gender, dob);
    }
}
