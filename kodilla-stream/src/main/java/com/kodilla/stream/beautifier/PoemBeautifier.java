package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String stringForBeautification, PoemDecorator poemDecorator) {
        String result = poemDecorator.decorate(stringForBeautification);
        System.out.println(result);
    }
}
