package com.ebay;

import com.ebay.entity.User;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UserInfoReader {
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
