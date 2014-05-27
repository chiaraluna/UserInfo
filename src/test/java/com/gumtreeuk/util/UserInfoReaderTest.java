package com.gumtreeuk.util;

import org.junit.Test;

import java.io.*;
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

    @Test
    public void testReadUserInfoFromString() {
        Reader reader = new StringReader("Bill McKnight, Male, 16/03/77\nPaul Robinson, Male, 15/01/85");
        DataParser parser = new DataParser();

        UserInfoReader userReader = new UserInfoReader(reader, parser);
        List usersActual = userReader.readUsers();
        assertEquals(2, usersActual.size());

    }
}
