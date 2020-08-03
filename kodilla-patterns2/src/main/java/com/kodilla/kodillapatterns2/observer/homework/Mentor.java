package com.kodilla.kodillapatterns2.observer.homework;

public class Mentor implements Observer {
    private String name;
    private int exercisesToCheck;

    public Mentor(String name) {
        this.name = name;
        this.exercisesToCheck = 0;
    }

    @Override
    public void update(StudentExerciseQueue studentExerciseQueue) {
        System.out.println("Mentor " + getName() +
                ": Student " + studentExerciseQueue.getQueueOwnerName() +
                " has sent through a new exercise for grading: " + studentExerciseQueue.getExercises().peekFirst() + ".");
        exercisesToCheck++;
    }

    public String getName() {
        return name;
    }

    public int getExercisesToCheck() {
        return exercisesToCheck;
    }
}
