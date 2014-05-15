package com.ebay;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class UserDataReaderTest {

    @Test
    public void readDataFromFile() {
        String fileName = "/AddressBook";
        UserDataReader reader = new UserDataReader(fileName);
        Set usersActual = reader.readUsers();

        assertEquals(5, usersActual.size());
    }
}
