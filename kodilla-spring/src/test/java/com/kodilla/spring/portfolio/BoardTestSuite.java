package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        TaskList toDoList = (TaskList) context.getBean("toDoList");
        TaskList inProgressList = (TaskList) context.getBean("inProgressList");
        TaskList doneList = (TaskList) context.getBean("doneList");


        // When
        board.addToDoTask("Prepare for the Winter");
        board.addInProgressTask("Eliminate all Starks");
        board.addDoneTask("Secure the Iron Throne");

        // Then
        Assert.assertEquals("Prepare for the Winter", toDoList.getTasks().get(0));
        Assert.assertEquals("Eliminate all Starks", inProgressList.getTasks().get(0));
        Assert.assertEquals("Secure the Iron Throne", doneList.getTasks().get(0));
    }
}
