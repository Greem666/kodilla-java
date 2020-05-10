package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        // When
        String resultAdd = calculator.add(2.0, 5.0);
        String resultSub = calculator.sub(2.0, 5.0);
        String resultMul = calculator.mul(2.0, 5.0);
        String resultDiv = calculator.div(5.0, 5.0);

        // Then
        Assert.assertEquals("Value: 7.0", resultAdd);
        Assert.assertEquals("Value: -3.0", resultSub);
        Assert.assertEquals("Value: 10.0", resultMul);
        Assert.assertEquals("Value: 1.0", resultDiv);
    }
}
