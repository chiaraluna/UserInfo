package com.gumtreeuk;

import com.gumtreeuk.entity.Gender;
import com.gumtreeuk.entity.User;
import com.gumtreeuk.service.UserService;

public class Runner {
    public static void main(String[] args) {
        UserService userService = new UserService();

        int malesCount = userService.countByGender(Gender.Male);
        User theOldestPerson = userService.findTheOldestPerson();
        long gapInDays = userService.getDaysBetween("Bill", "Paul");

        System.out.println("How many males are in the address book?");
        System.out.println(malesCount);

        System.out.println("\nWho is the oldest person in the address book?");
        System.out.println(theOldestPerson.name);

        System.out.println("\nHow many days older is Bill than Paul?");
        System.out.println(gapInDays);
    }
}
