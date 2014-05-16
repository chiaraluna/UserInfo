package com.gumtreeuk.util;

import com.gumtreeuk.entity.Gender;
import com.gumtreeuk.entity.User;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DataParser {

    private static final String DELIM = ", ";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

    public static User parse(String userInfoLine) throws ParseException {
        String[] data = userInfoLine.split(DELIM);
        validate(data);
        String name = data[0];
        Gender gender;
        try {
            gender = Gender.valueOf(data[1]);
        } catch (IllegalArgumentException ex) {
            throw new ParseException("gender should be Male or Female", 1);
        }
        Date date = dateFormat.parse(data[2]);
        return new User(name, gender, date.getTime());
    }

    private static void validate(String[] data) throws ParseException {
        if (data.length < 2) {
            throw new ParseException("There is not enough parameters", data.length -1);
        }
    }

    public static class UserInfoReader {
        private final String fileName;
        private static Logger logger = Logger.getLogger(UserInfoReader.class);
        private String userInfoLine;

        public UserInfoReader(String fileName) {
            this.fileName = fileName;
        }

        public List<User> readUsers() {
            List<User> result = new LinkedList<User>();

            InputStream inputStream = UserInfoReader.class.getResourceAsStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                try {
                    userInfoLine = scanner.nextLine();
                    User user = parse(userInfoLine);
                    result.add(user);
                } catch (ParseException e) {
                    logger.error("User info " + userInfoLine + " cannot be parsed: " + userInfoLine);
                }
            }
            scanner.close();
            return result;
        }
    }
}
