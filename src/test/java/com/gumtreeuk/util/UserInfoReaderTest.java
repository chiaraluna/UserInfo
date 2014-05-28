package com.gumtreeuk.util;

import org.junit.Test;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInfoReaderTest {

    @Test
    public void testReadUserInfo() {
        String fileName = "/AddressBook";
        InputStream inputStream = this.getClass().getResourceAsStream(fileName);
        Reader reader = new BufferedReader(new InputStreamReader(inputStream));
        DataParser parser = new DataParser();

        UserInfoReader userReader = new UserInfoReader(reader, parser);
        List usersActual = userReader.readUsers();
        assertThat(usersActual).hasSize(5);

    }

    @Test
    public void testReadUserInfoFromString() {
        Reader reader = new StringReader("Bill McKnight, Male, 16/03/77\nPaul Robinson, Male, 15/01/85");
        DataParser parser = new DataParser();

        UserInfoReader userReader = new UserInfoReader(reader, parser);
        List usersActual = userReader.readUsers();
        assertThat(usersActual).hasSize(2);

    }
}
