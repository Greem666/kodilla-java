package com.kodilla.patterns.factory.tasks;

public class DrivingTaskFactory extends TaskFactory {
    @Override
    protected Task createTask() {
        return new DrivingTask("Driving merrily", "countryside", "unicycle");
    }
}
