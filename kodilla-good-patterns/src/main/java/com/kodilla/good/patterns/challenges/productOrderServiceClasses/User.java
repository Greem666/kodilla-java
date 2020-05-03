package com.kodilla.good.patterns.challenges.productOrderServiceClasses;

import java.sql.Timestamp;
import java.util.Date;

public class User {
    private String name;
    private Date lastLoginDate;

    public User(String name) {
        this.name = name;
        this.lastLoginDate = generateRandomLastLoginDate();
    }

    public String getName() {
        return name;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    private Date generateRandomLastLoginDate() {
        long beginTime = Timestamp.valueOf("2020-01-01 00:00:00").getTime();
        long endTime = Timestamp.valueOf("2020-05-03 00:00:00").getTime();

        long diff = endTime - beginTime + 1;

        return new Date(beginTime + (long) (Math.random() * diff));
    }
}
