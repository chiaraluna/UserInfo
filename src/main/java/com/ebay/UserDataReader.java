package com.ebay;

import com.ebay.entity.User;

import java.io.*;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class UserDataReader {
    private final String fileName;

    public UserDataReader(String fileName) {
        this.fileName = fileName;
    }

    public Set readUsers() {
        TreeSet<User> result = new TreeSet<User>();
        Scanner scanner = null;
        try {
            InputStream inputStream = UserDataReader.class.getResourceAsStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                User user = DataParser.parse(scanner.nextLine());
                result.add(user);
            }
        } catch (ParseException e) {
            return result;
        }
        finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return result;
    }
}
