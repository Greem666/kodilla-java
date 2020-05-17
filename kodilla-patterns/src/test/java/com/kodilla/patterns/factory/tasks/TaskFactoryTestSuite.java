package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testShoppingTaskFactory() {
        // Given
        TaskFactory shoppingFactory = new ShoppingTaskFactory();

        // When
        Task shoppingTask = shoppingFactory.createTask();
        boolean initialExecutedStatus = shoppingTask.isTaskExecuted();
        shoppingTask = shoppingFactory.doTask();

        // Then
        Assert.assertEquals("Ferrocious shopping spree", shoppingTask.getTaskName());
        Assert.assertFalse(initialExecutedStatus);
        Assert.assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    public void testDrivingTaskFactory() {
        // Given
        TaskFactory drivingFactory = new DrivingTaskFactory();

        // When
        Task drivingTask = drivingFactory.createTask();
        boolean initialExecutedStatus = drivingTask.isTaskExecuted();
        drivingTask = drivingFactory.doTask();

        // Then
        Assert.assertEquals("Driving merrily", drivingTask.getTaskName());
        Assert.assertFalse(initialExecutedStatus);
        Assert.assertTrue(drivingTask.isTaskExecuted());
    }

    @Test
    public void testPaintingTaskFactory() {
        // Given
        TaskFactory paintingFactory = new PaintingTaskFactory();

        // When
        Task paintingTask = paintingFactory.createTask();
        boolean initialExecutedStatus = paintingTask.isTaskExecuted();
        paintingTask = paintingFactory.doTask();

        // Then
        Assert.assertEquals("Inspired painting", paintingTask.getTaskName());
        Assert.assertFalse(initialExecutedStatus);
        Assert.assertTrue(paintingTask.isTaskExecuted());
    }
}
