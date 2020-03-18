package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.TextBeautificator;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.SaySomething;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.util.regex.Pattern;

public class StreamMain {

    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.execute(() -> System.out.println("This is a test text from a Lambda Function!"));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambda");
        expressionExecutor.executeExpression(5, 10, (a, b) -> a + b);
        expressionExecutor.executeExpression(5, 10, (a, b) -> a - b);
        expressionExecutor.executeExpression(5, 10, (a, b) -> a * b);
        expressionExecutor.executeExpression(5, 10, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(5, 10, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(5, 10, FunctionalCalculator::subAFromB);
        expressionExecutor.executeExpression(5, 10, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(5, 10, FunctionalCalculator::divideAByB);


        PoemBeautifier poemBeautifier = new PoemBeautifier();

        System.out.println("Now working with PoemBeautifier");
        String textForBeautification = "Beautify this text please! 111 222 333 444 555";
        poemBeautifier.beautify(textForBeautification, string -> "Added ABC/XYZ: " + "ABC---> " + string + " <---XYZ");
        poemBeautifier.beautify(textForBeautification, string -> "To lower case: " + string.toLowerCase());
        poemBeautifier.beautify(textForBeautification, string -> "Digits replaced with 'digits': " + string.replaceAll("\\d+", "digits"));
        poemBeautifier.beautify(textForBeautification, string -> "Middlepoint of text marked: " + string.substring(0, string.length() / 2) + "<--- MIDDLE OF THE TEXT --->" +  string.substring(string.length() / 2));
        poemBeautifier.beautify(textForBeautification, TextBeautificator::generateWavyText);
        poemBeautifier.beautify(textForBeautification, TextBeautificator::randomizeWordOrder);

    }

}
