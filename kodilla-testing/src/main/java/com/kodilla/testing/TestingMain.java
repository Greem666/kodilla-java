package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {

        System.out.println("Test - test klasy SimpleUser");

        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Test - pierwszy test jednostkowy:");
        if (Calculator.add(4, 19) == 23) {
            System.out.println("Calculator.add() test OK");
        } else {
            System.out.println("Calculator.add() Error");
        }

        if (Calculator.subtract(4, 19) == -15) {
            System.out.println("Calculator.subtract() test OK");
        } else {
            System.out.println("Calculator.subtract() Error");
        }
    }
}
