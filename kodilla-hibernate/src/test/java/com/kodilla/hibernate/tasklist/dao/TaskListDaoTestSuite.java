package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.dao.TaskDao;
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
    @Autowired
    private TaskDao taskDao;
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

    @Test
    public void testNamedQueries() {
        // Given
        Task task1 = new Task("Watch Rick and Morty", 30);
        Task task2 = new Task("Watch YouTube about R&M", 60);
        Task task3 = new Task("Obsess about R&M at work", 8);
        Task task4 = new Task("Get depressed while waiting for season 5", 4);

        TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal(7.99), true);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(3.99), true);
        TaskFinancialDetails tfd3 = new TaskFinancialDetails(new BigDecimal(0.99), false);
        TaskFinancialDetails tfd4 = new TaskFinancialDetails(new BigDecimal(13.99), false);

        task1.setTaskFinancialDetails(tfd1);
        task2.setTaskFinancialDetails(tfd2);
        task3.setTaskFinancialDetails(tfd3);
        task4.setTaskFinancialDetails(tfd4);

        TaskList taskList = new TaskList("Done", "R&M tasks list");
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);
        taskList.getTasks().add(task3);
        taskList.getTasks().add(task4);

        task1.setTaskList(taskList);
        task2.setTaskList(taskList);
        task3.setTaskList(taskList);
        task4.setTaskList(taskList);

        taskListDao.save(taskList);
        int taskListId = taskList.getId();

        // When
        List<Task> longTasks = taskDao.retrieveLongTasks();
        List<Task> shortTasks = taskDao.retrieveShortTasks();
        List<Task> enoughTimeTasks = taskDao.retrieveTasksWithEnoughTime();
        List<Task> tasksLongerThan4Days = taskDao.retrieveTasksWithDurationGreaterThan(4);

        // Then
        try {
            Assert.assertEquals(2, longTasks.size());
            Assert.assertEquals(2, shortTasks.size());
            Assert.assertEquals(3, enoughTimeTasks.size());
            Assert.assertEquals(3, tasksLongerThan4Days.size());
        } finally {
            taskListDao.deleteById(taskListId);
        }

    }

}
