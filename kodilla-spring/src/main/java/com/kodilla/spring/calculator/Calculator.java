package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {
    @Autowired
    private Display display;

    public String add(double a, double b) {
        return display.displayValue(a + b);
    }

    public String sub(double a, double b) {
        return display.displayValue(a - b);
    }

    public String mul(double a, double b) {
        return display.displayValue(a * b);
    }

    public String div(double a, double b) {
        return display.displayValue(a / b);
    }
}
