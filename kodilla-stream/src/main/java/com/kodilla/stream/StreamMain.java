package com.kodilla.stream;

import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.SaySomething;

public class StreamMain {

    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.execute(() -> System.out.println("This is a test text from a Lambda Function!"));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(5, 10, (a, b) -> a + b);
        expressionExecutor.executeExpression(5, 10, (a, b) -> a - b);
        expressionExecutor.executeExpression(5, 10, (a, b) -> a * b);
        expressionExecutor.executeExpression(5, 10, (a, b) -> a / b);
    }

}
