package com.gumtreeuk.entity;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertSame;

public class UserInfoHolderTest {

    @Test
    public void testReadsFromFileOnce(){
        UserInfoHolder userInfoHolder = new UserInfoHolder();
        List<User> usersFromFile = userInfoHolder.getUsers();
        List<User> users = userInfoHolder.getUsers();
        assertSame(usersFromFile, users);
    }
}
