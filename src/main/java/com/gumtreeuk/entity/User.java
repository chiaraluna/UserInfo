package com.gumtreeuk.entity;

public class User implements Comparable<User>{
    public final String name;
    public final Gender gender;
    public final long dobInMs;

    public User(String name, Gender gender, long dobInMs) {
        this.name = name;
        this.gender = gender;
        this.dobInMs = dobInMs;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", dobInMs=" + dobInMs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (dobInMs != user.dobInMs) return false;
        if (gender != user.gender) return false;
        if (!name.equals(user.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + (int) (dobInMs ^ (dobInMs >>> 32));
        return result;
    }

    @Override
    public int compareTo(User user) {
        return name.compareTo(user.name);
    }
}
