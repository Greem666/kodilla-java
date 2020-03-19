package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> forumUsersList = new ArrayList<>();

    public Forum() {
        this.forumUsersList.add(new ForumUser("0001", "greem666", 'M',
                2004, 11, 11, 200));
        this.forumUsersList.add(new ForumUser("0002", "greema666", 'F',
                1983, 12, 6, 20));
        this.forumUsersList.add(new ForumUser("0003", "Nana", 'F',
                1993, 1, 6, 340));
        this.forumUsersList.add(new ForumUser("0004", "LurkerInTheForest", 'M',
                1968, 6, 6, 2045));
        this.forumUsersList.add(new ForumUser("0005", "SisterNightingale", 'F',
                1953, 2, 2, 207));
        this.forumUsersList.add(new ForumUser("0006", "Lupin", 'M',
                1982, 7, 10, 1200));
        this.forumUsersList.add(new ForumUser("0007", "Balthazar", 'M',
                1983, 12, 31, 1031));
        this.forumUsersList.add(new ForumUser("0008", "MrsBazooka", 'F',
                1991, 1, 1, 3402));
        this.forumUsersList.add(new ForumUser("0009", "MrBazooka", 'M',
                1991, 2, 2, 3045));
        this.forumUsersList.add(new ForumUser("0010", "PanCzapla", 'M',
                2006, 9, 21, 20734));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUsersList);
    }
}
