package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.TaskFinancialDetails;
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
public class TaskFinancialDetailsTestSuite {
    @Autowired
    private TaskFinancialDetailsDao taskFinancialDetailsDao;

    @Test
    public void testFindByPaid() {
        // Given
        TaskFinancialDetails taskFinancialDetails = new TaskFinancialDetails(new BigDecimal(115), false);
        taskFinancialDetailsDao.save(taskFinancialDetails);
        int id = taskFinancialDetails.getId();

        // When
        List<TaskFinancialDetails> results = taskFinancialDetailsDao.findByPaid(false);

        // Then
        Assert.assertEquals(id, results.get(0).getId());
        Assert.assertEquals(1, results.size());

        // Clean-up
        taskFinancialDetailsDao.deleteById(id);
    }
}
