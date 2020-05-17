package com.kodilla.patterns.factory.tasks;

public abstract class TaskFactory {
    Task task;

    public void doTask() {
        task = createTask();
        task.executeTask();
        System.out.println(task.getTaskName() + " is now executed: " + task.isTaskExecuted());
    }

    protected abstract Task createTask();
}
