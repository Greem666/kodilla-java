package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {
    private String taskName;
    private String where;
    private String using;
    private boolean isExecuted = false;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public void executeTask() {
        isExecuted = true;
        System.out.println(taskName + ": to " + where + " by " + using);
    }

    @Override
    public boolean isTaskExecuted() {
        return isExecuted;
    }

    public String getTaskName() {
        return taskName;
    }
}
