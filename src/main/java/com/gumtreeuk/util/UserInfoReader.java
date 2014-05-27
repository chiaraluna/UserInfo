package com.gumtreeuk.util;

import com.gumtreeuk.entity.User;
import org.apache.log4j.Logger;

import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInfoReader {
    private final Reader reader;
    private final DataParser parser;
    private Logger logger = Logger.getLogger(UserInfoReader.class);

    public UserInfoReader(Reader reader, DataParser parser) {
        this.reader = reader;
        this.parser = parser;
    }

    public List<User> readUsers() {
        List<User> result = new ArrayList<User>();

        Scanner scanner = new Scanner(reader);
        String userInfoLine = "";
        while (scanner.hasNextLine()) {
            try {
                userInfoLine = scanner.nextLine();
                User user = parser.parse(userInfoLine);
                result.add(user);
            } catch (ParseException e) {
                logger.error("User info " + userInfoLine + " cannot be parsed: " + userInfoLine);
            }
        }
        scanner.close();
        return result;
    }
}
