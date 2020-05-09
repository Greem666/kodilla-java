package com.kodilla.spring.intro.shape;

public class Circle implements Shape {
    @Override
    public String draw() {
        String output = "This is a circle!";
        System.out.println(output);
        return output;
    }
}
