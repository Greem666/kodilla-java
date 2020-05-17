package com.kodilla.patterns.factory.tasks;

public class ShoppingTaskFactory extends TaskFactory{
    @Override
    protected Task createTask() {
        return new ShoppingTask("Ferrocious shopping spree", "EVERYTHING", 2);
    }
}
