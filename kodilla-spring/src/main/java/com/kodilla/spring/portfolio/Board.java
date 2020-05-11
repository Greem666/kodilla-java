package com.kodilla.spring.portfolio;

public class Board {
    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public void addToDoTask(String task) {
        addTaskToList(toDoList, task);
    }

    public void addInProgressTask(String task) {
        addTaskToList(inProgressList, task);
    }

    public void addDoneTask(String task) {
        addTaskToList(doneList, task);
    }

    private void addTaskToList(TaskList theList, String task) {
        theList.addTask(task);
    }
}
