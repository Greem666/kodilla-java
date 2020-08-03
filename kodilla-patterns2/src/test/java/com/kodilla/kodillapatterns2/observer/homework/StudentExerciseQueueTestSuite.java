package com.kodilla.kodillapatterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentExerciseQueueTestSuite {
    @Test
    public void testStudentExercisesSubscription() {
        // Given
        StudentExerciseQueue mattGreenQueue = new StudentExerciseQueue("Matt Green");
        StudentExerciseQueue joPinkQueue = new StudentExerciseQueue("Jo Pink");
        StudentExerciseQueue danWhiteQueue = new StudentExerciseQueue("Dan White");

        Mentor dumbledore = new Mentor("Dumbledore");
        Mentor gandalf = new Mentor("Gandalf");

        mattGreenQueue.addObserver(dumbledore);
        mattGreenQueue.addObserver(gandalf);
        joPinkQueue.addObserver(gandalf);
        danWhiteQueue.addObserver(dumbledore);

        // When
        mattGreenQueue.addExercise("Exercise 24.1 solution");
        joPinkQueue.addExercise("Exercise 24.2 solution");
        danWhiteQueue.addExercise("Exercise 24.3 solution");
        joPinkQueue.addExercise("Exercise 24.4 solution");

        // Then
        assertEquals(2, dumbledore.getExercisesToCheck());
        assertEquals(3, gandalf.getExercisesToCheck());
    }
}
