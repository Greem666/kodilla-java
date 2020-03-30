package com.kodilla.exception.test;

import java.util.List;

public class NullAirportListHandler {
    public static void safeAddToList(List<List<String>> listOfLists, List<String> newList) {
        try {
            listOfLists.add(newList);
        } catch (NullPointerException e) {
            System.out.println(newList + " was empty! " + e + " Skipping it...");
        }
    }
}
