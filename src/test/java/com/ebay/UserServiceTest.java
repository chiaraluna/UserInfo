package com.ebay;

import com.ebay.entity.Gender;
import com.ebay.entity.User;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(JUnitParamsRunner.class)
public class UserServiceTest {


    UserService userService = Mockito.spy(new UserService());

    @Test
    @Parameters(method = "genderValues")
    public void testTheNumberOfPeopleOfGender(int maleNumber, int femaleNumber, Gender genderToFind, int correctNumber) {


        List<User> users = new LinkedList<User>();
        addUsers(maleNumber, Gender.Male, users);
        addUsers(femaleNumber, Gender.Female, users);

        doReturn(users).when(userService).getUsers();

        long genderNumber = userService.countByGender(genderToFind);
        assertEquals(correctNumber, genderNumber);
    }

    private void addUsers(int number, Gender gender, List<User> users) {
        for (int i = 0; i < number; i++) {
            users.add(new User("User", gender, new GregorianCalendar()));
        }
    }

    private Object[] genderValues() {
        return $(
                $(3, 2, Gender.Female, 2),
                $(3, 2, Gender.Male, 3),
                $(1, 0, Gender.Female, 0),
                $(1, 0, Gender.Male, 1),
                $(0, 3, Gender.Female, 3),
                $(0, 3, Gender.Male, 0)
        );
    }

}
