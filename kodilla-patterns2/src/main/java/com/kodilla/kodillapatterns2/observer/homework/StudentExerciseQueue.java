package com.kodilla.kodillapatterns2.observer.homework;

import java.util.*;

public class StudentExerciseQueue implements Observable {
    private Deque<String> exercises;
    private List<Observer> observers;
    private String queueOwnerName;

    public StudentExerciseQueue(String queueOwnerName) {
        this.queueOwnerName = queueOwnerName;
        this.exercises = new ArrayDeque<>();
        this.observers = new ArrayList<>();
    }

    public void addExercise(String exercise) {
        exercises.offer(exercise);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update(this);
        }
    }

    public Deque<String> getExercises() {
        return exercises;
    }

    public String getQueueOwnerName() {
        return queueOwnerName;
    }
}
