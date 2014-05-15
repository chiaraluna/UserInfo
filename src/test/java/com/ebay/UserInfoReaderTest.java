package com.ebay;

import com.ebay.entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserInfoReaderTest {

    @Test
    public void readDataFromFile() {
        String fileName = "/AddressBook";
        UserInfoReader reader = new UserInfoReader(fileName);
        List<User> usersActual = reader.readUsers();

        assertEquals(5, usersActual.size());
    }


}
