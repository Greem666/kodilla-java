package com.kodilla.patterns.factory.tasks;

public abstract class TaskFactory {
    Task task;

    public Task doTask() {
        task = createTask();
        task.executeTask();
        System.out.println(task.getTaskName() + " is now executed: " + task.isTaskExecuted());

        return task;
    }

    protected abstract Task createTask();
}
