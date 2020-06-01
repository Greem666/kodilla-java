package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskDaoTestSuite {
    @Autowired
    private TaskDao taskDao;
    private static final String DESCRIPTION = "Test: LEARN HIBERNATE";

    @Test
    public void testTaskDaoSave() {
        // Given
        Task task = new Task(DESCRIPTION, 7);

        // When
        taskDao.save(task);

        // Then
        int id = task.getId();
        Optional<Task> readTask = taskDao.findById(id);
        Assert.assertTrue(readTask.isPresent());

        // Clean-up
        taskDao.deleteById(id);
    }

    @Test
    public void testFindByDuration() {
        // Given
        Task task = new Task(DESCRIPTION, 7);
        taskDao.save(task);
        int duration = task.getDuration();

        // When
        List<Task> readTasks = taskDao.findByDuration(duration);

        // Then
        Assert.assertEquals(1, readTasks.size());

        //Clean-up
        int id = readTasks.get(0).getId();
        taskDao.deleteById(id);
    }
}
