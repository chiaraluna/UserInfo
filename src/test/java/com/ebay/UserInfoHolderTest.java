package com.ebay;

import com.ebay.entity.User;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertSame;

public class UserInfoHolderTest {

    @Test
    public void readsFromFileOnce(){
        Set<User> usersFromFile = UserInfoHolder.getUsers();
        Set<User> users = UserInfoHolder.getUsers();
        assertSame(usersFromFile, users);


    }

}
