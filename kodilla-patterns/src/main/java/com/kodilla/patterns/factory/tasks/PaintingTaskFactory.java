package com.kodilla.patterns.factory.tasks;

public class PaintingTaskFactory extends TaskFactory {
    @Override
    protected Task createTask() {
        return new PaintingTask("Inspired painting", "white", "darkness");
    }
}
