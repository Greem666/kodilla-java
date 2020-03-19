package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        Forum forum = new Forum();
        Map<String, ForumUser> resultUsersMap = forum.getUserList().stream()
                .filter(user -> user.getGender() == 'M')
                .filter(user -> user.getDateOfBirth().isBefore(
                        LocalDate.of(
                                LocalDate.now().getYear() - 20,
                                LocalDate.now().getMonth(),
                                LocalDate.now().getDayOfMonth())))
                .filter(user -> user.getPostCount() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserId, user -> user));

        resultUsersMap.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }

}
