package com.kodilla.exception.test;

public class ExceptionHandling {

    public static String handle(SecondChallenge secondChallenge, double... args) {
        String output = null;

        try {
            output = secondChallenge.probablyIWillThrowException(args[0], args[1]);
        } catch (Exception e) {
            System.out.println("An exception occurred while executing method \"probablyIWillThrowException\" (duh!)");
        } finally {
            System.out.println("\"probablyIWillThrowException\" method has been run.");
        }

        return output;
    }
}
