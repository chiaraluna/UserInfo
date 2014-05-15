package com.ebay;

import com.ebay.entity.User;
import org.apache.log4j.Logger;

import java.io.*;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class UserInfoReader {
    private final String fileName;
    private static Logger logger = Logger.getLogger(UserInfoReader.class);
    private String userInfoLine;

    public UserInfoReader(String fileName) {
        this.fileName = fileName;
    }

    public Set readUsers() {
        TreeSet<User> result = new TreeSet<User>();

        InputStream inputStream = UserInfoReader.class.getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()) {
            try {
                userInfoLine = scanner.nextLine();
                User user = DataParser.parse(userInfoLine);
                result.add(user);
            } catch (ParseException e) {
                logger.error("User info " + userInfoLine + " cannot be parsed: " + userInfoLine);
            }
        }
        scanner.close();
        return result;
    }
}
