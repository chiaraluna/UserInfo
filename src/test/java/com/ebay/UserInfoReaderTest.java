package com.ebay;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class UserInfoReaderTest {

    @Test
    public void readDataFromFile() {
        String fileName = "/AddressBook";
        UserInfoReader reader = new UserInfoReader(fileName);
        Set usersActual = reader.readUsers();

        assertEquals(5, usersActual.size());
    }


}
