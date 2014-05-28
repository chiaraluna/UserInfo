package com.gumtreeuk.entity;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInfoHolderTest {

    @Test
    public void testReadsFromFileOnce(){
        UserInfoHolder userInfoHolder = new UserInfoHolder();
        List<User> users = userInfoHolder.getUsers();
        List<User> usersFromCache = userInfoHolder.getUsers();

        assertThat(users).isSameAs(usersFromCache);
    }
}
