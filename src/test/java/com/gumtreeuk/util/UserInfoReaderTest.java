package com.gumtreeuk.util;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserInfoReaderTest {

    @Test
    public void testReadUserInfo() {
        String fileName = "/AddressBook";
        InputStream inputStream = this.getClass().getResourceAsStream(fileName);
        Reader reader = new BufferedReader(new InputStreamReader(inputStream));
        DataParser parser = new DataParser();

        UserInfoReader userReader = new UserInfoReader(reader, parser);
        List usersActual = userReader.readUsers();
        assertEquals(5, usersActual.size());

    }
}
