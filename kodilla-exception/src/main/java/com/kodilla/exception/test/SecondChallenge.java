package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class SecondChallenge {
    public String probablyIWillThrowException(double x, double y) throws Exception {
        if (x >= 2 || x < 1 || y ==1.5) {
            throw new Exception();
        }
        return "Done!";
    }

    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        Random random = new Random();
        double range = 4.0;
        List<double[]> testData = IntStream.range(0, 10)
                .mapToObj(s -> new double[]{
                        random.nextDouble() * range,
                        random.nextDouble() * range
                })
                .collect(Collectors.toList());

        int counter = 1;
        for (double[] data: testData) {
            double x = data[0];
            double y = data[1];
            String result = ExceptionHandling.handle(secondChallenge, x, y);

            System.out.println(String.format("Test case %d: x = %.2f, y = %.2f", counter, x, y));
            System.out.println(result);
            System.out.println("***********************");

            counter++;
        }
    }
}
