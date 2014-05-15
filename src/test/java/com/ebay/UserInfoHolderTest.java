package com.ebay;

import com.ebay.entity.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertSame;

public class UserInfoHolderTest {

    @Test
    public void readsFromFileOnce(){
        UserInfoHolder userInfoHolder = new UserInfoHolder();
        List<User> usersFromFile = userInfoHolder.getUsers();
        List<User> users = userInfoHolder.getUsers();
        assertSame(usersFromFile, users);


    }

}
