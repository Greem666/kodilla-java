package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private final String userId;
    private final String username;
    private final char gender;
    private final LocalDate dateOfBirth;
    private final int postCount;

    public ForumUser(String userId, String username, char gender, int yearOfBirth,
                     int monthOfBirth, int dayOfBirth, int postCount) {
        this.userId = userId;
        this.username = username;
        this.gender = gender;
        this.dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.postCount = postCount;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostCount() {
        return postCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", postCount=" + postCount +
                '}';
    }
}
