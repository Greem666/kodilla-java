package com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class RandomTravelGenerator {
    private final List<String> validCities = new ArrayList<>(
            Arrays.asList(
                    "Warsaw", "Wroclaw", "Gdansk", "Poznan", "Bialystok", "Cracow", "Lodz",
                    "Prague", "Brno", "Ostrava", "Karlovy Vary", "Pardubice",
                    "Budapest", "Debrecen", "Sarmellek", "Gyor-Per", "Pecs-Pogany",
                    "Bratislava", "Košice", "Zilina", "Banska Bystrica", "Trnava", "Nitra", "Presov", "Trencin"
            )
    );
    private Random random = new Random();
    private LocalDateTime currentTimePoint;

    public ArrayList<Flight> generateRandomFlightRouteBatch(int quantity) {
        ArrayList<Flight> flights = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            flights.add(generateRandomFlightRoute());
        }

        return flights;
    }

    public Flight generateRandomFlightRoute() {
        List<String> validCitiesCopy = new ArrayList<>(validCities);

        // ORIGIN
        String departureAirport = generateRandomCity(validCitiesCopy);

        // DESTINATION
        String arrivalAirport = generateRandomCity(validCitiesCopy);

        // COST
        double cost = random.nextDouble() * 1000;

        return new Flight(departureAirport, arrivalAirport);
    }

    private String generateRandomCity(List<String> validCities) {
        String chosenCity = validCities.get(random.nextInt(validCities.size()));
        validCities.remove(chosenCity);

        return chosenCity;
    }
}
