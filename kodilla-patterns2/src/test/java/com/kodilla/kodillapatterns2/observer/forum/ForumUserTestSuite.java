package com.kodilla.kodillapatterns2.observer.forum;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForumUserTestSuite {
    @Test
    public void testUpdate() {
        // Given
        ForumTopic javaHelpForum = new JavaHelpForumTopic();
        ForumTopic javaToolsForum = new JavaToolsForumTopic();

        ForumUser johnSmith = new ForumUser("John Smith");
        ForumUser ivoneEscobar = new ForumUser("Ivone Escobar");
        ForumUser jessePinkman = new ForumUser("Jesse Pinkman");

        javaHelpForum.registerObserver(johnSmith);
        javaHelpForum.registerObserver(jessePinkman);

        javaToolsForum.registerObserver(jessePinkman);
        javaToolsForum.registerObserver(ivoneEscobar);

        // When
        javaHelpForum.addPost("Hi everyone! Could you help me with for loop?");
        javaHelpForum.addPost("Better try to use while loop in this case.");
        javaHelpForum.addPost("Why while? Is it better?");

        javaToolsForum.addPost("Help pls, my MySQL db doesn`t want to work :(");
        javaToolsForum.addPost("When I try to log in I got 'bad credentials' message.");

        // Then
        assertEquals(3, johnSmith.getUpdateCount());
        assertEquals(2, ivoneEscobar.getUpdateCount());
        assertEquals(5, jessePinkman.getUpdateCount());
    }
}
