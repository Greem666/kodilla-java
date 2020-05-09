package com.kodilla.spring.intro.shape;

public class Triangle implements Shape {
    @Override
    public String draw() {
        String output = "This is a triangle!";
        System.out.println(output);
        return output;
    }
}
