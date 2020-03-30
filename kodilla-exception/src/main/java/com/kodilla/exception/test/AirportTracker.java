package com.kodilla.exception.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AirportTracker {

    public Map<String, Boolean> listAllAirports() {
        Map<String, Boolean> airportsList = new HashMap<>();

        List<String> availableAirports = listAvailableAirports();
        for (String airport: availableAirports) {
            airportsList.put(airport, true);
        }

        List<String> otherAirports = listOtherAirports();
        for (String airport: otherAirports) {
            airportsList.put(airport, false);
        }

        return airportsList;
    }

    private List<String> listAvailableAirports() {
        return new ArrayList<String>(listAvailablePolishAirports());
    }

    private List<String> listOtherAirports() {
        List<List<String>> listsOfOtherAirports = new ArrayList<>();

        for (List<String> airportList: new List[]{listAvailableCzechAirports(), listAvailableGermanAirports(),
                listAvailableUkrainianAirports(), listAvailableFrenchAirports()}) {

            NullAirportListHandler.safeAddToList(listsOfOtherAirports, airportList);
        }

        return listsOfOtherAirports.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<String> listAvailablePolishAirports() {
        return listAirports("polishAirports.txt");
    }

    private List<String> listAvailableGermanAirports() {
        return listAirports("germanAirports.txt");
    }

    private List<String> listAvailableCzechAirports() {
        return listAirports("czechAirports.txt");
    }

    private List<String> listAvailableUkrainianAirports() {
        return listAirports("ukrainianAirports.txt");
    }

    private List<String> listAvailableFrenchAirports() {
        return listAirports("frenchAirports.txt");
    }

    private List<String> listAirports(String fileName) {
        try {
            return readInAirports(fileName);
        } catch (IOException e) {
            throw new NullPointerException("List of " + fileName + " not found!");
        }
    }

    private List<String> readInAirports(String fileName) throws IOException {
//        String relativeFilePath = "airports/" + fileName;
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        Path path = Paths.get(file.getPath());

        Stream<String> fileLines = Files.lines(path);
        List<String> availableAirports = fileLines.collect(Collectors.toList());

        return availableAirports;
    }
}
