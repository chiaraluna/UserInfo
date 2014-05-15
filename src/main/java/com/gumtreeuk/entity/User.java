package com.gumtreeuk.entity;

import java.util.Calendar;

public class User implements Comparable<User>{
    public final String name;
    public final Gender gender;
    public final Calendar dob;

    public User(String name, Gender gender, Calendar dob) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", dob=" + dob +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!dob.equals(user.dob)) return false;
        if (gender != user.gender) return false;
        if (!name.equals(user.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + dob.hashCode();
        return result;
    }

    @Override
    public int compareTo(User user) {
        return name.compareTo(user.name);
    }
}
