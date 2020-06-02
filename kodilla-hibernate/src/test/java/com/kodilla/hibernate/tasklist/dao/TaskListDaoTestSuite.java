package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
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

    @Test
    public void testTaskListDaoSaveWithTasks() {
        // Given
        Task task = new Task(DESCRIPTION, 14);
        Task task2 = new Task(DESCRIPTION + "; Write some entities.", 3);

        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);

        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);

        TaskList taskList = new TaskList("ToDos", "ToDoList");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);

        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        // When
        taskListDao.save(taskList);
        int id = taskList.getId();

        // Then
        Assert.assertNotEquals(0, id);

        // Clean-up
        taskListDao.deleteById(id);
    }

}
