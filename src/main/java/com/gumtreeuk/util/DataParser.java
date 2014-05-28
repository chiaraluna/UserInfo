package com.gumtreeuk.util;

import com.gumtreeuk.entity.Gender;
import com.gumtreeuk.entity.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataParser {

    private static final String DELIM = ", ";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

    public User parse(String userInfoLine) throws ParseException {
        String[] data = userInfoLine.split(DELIM);
        validate(data);
        String name = data[0];
        Gender gender;
        try {
            gender = Gender.valueOf(data[1]);
        } catch (IllegalArgumentException ex) {
            throw new ParseException("Gender should be Male or Female", 1);
        }
        Date date = dateFormat.parse(data[2]);
        return new User(name, gender, date.getTime());
    }

    private void validate(String[] data) throws ParseException {
        if (data.length < 3) {
            throw new ParseException("There is not enough parameters", data.length - 1);
        }
    }
}
