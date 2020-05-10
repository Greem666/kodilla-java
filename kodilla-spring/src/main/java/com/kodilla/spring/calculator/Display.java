package com.kodilla.spring.calculator;

import org.springframework.stereotype.Component;

@Component
public class Display {
    public String displayValue(double val) {
        String output = "Value: " + val;
        System.out.println(output);
        return output;
    }
}
