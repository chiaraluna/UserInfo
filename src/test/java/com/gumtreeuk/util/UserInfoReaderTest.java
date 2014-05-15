package com.gumtreeuk.util;

import com.gumtreeuk.entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserInfoReaderTest {

    @Test
    public void testReadDataFromFile() {
        String fileName = "/AddressBook";
        DataParser.UserInfoReader reader = new DataParser.UserInfoReader(fileName);
        List<User> usersActual = reader.readUsers();

        assertEquals(5, usersActual.size());
    }


}
