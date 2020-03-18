package com.kodilla.stream.beautifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TextBeautificator {
    public static String generateWavyText(String string) {
        String output = "";
        char[] stringArray = string.toCharArray();
        for (int i = 0; i < string.length(); i++) {
            String letter = ((Character)stringArray[i]).toString();
            if (i % 2 == 0) {
                output += letter.toLowerCase();
            } else {
                output += letter.toUpperCase();
            }
        }
        return "Wavy text: " + output;
    }
    public static String randomizeWordOrder(String string) {
        List<String> wordsList = new ArrayList<>(Arrays.asList(string.split("\\s")));
        List<String> newWordsList = new ArrayList<>();
        Random random = new Random();

        while(!wordsList.isEmpty()) {
            int nextIdx = random.nextInt(wordsList.size());
            newWordsList.add(wordsList.remove(nextIdx));
        }

        return "Randomized words: " + String.join(" ", newWordsList);
    }
}
