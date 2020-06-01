package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String DESCRIPTION = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation...";

    @Test
    public void testFindByListName() {
        // Given
        TaskList taskList = new TaskList("ToDo", DESCRIPTION);
        taskListDao.save(taskList);
        String listName = taskList.getListName();

        // When
        List<TaskList> taskLists = taskListDao.findByListName(listName);

        // Then
        Assert.assertEquals(1, taskLists.size());

        // Clean-up
        taskListDao.deleteById(taskLists.get(0).getId());
    }
}
