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
        currentTimePoint = LocalDateTime.now().plus(pickRandomDaysDuration());

        // ORIGIN
        String departureAirport = generateRandomCity(validCitiesCopy);
        LocalDateTime departureDateTime = generateNextDateTimePoint();

        // DESTINATION
        String arrivalAirport = generateRandomCity(validCitiesCopy);
        LocalDateTime arrivalDateTime = generateNextDateTimePoint();

        // COST
        double cost = random.nextDouble() * 1000;

        return new Flight(departureAirport, departureDateTime, arrivalAirport, arrivalDateTime, cost);
    }

    private String generateRandomCity(List<String> validCities) {
        String chosenCity = validCities.get(random.nextInt(validCities.size()));
        validCities.remove(chosenCity);

        return chosenCity;
    }

    private LocalDateTime generateNextDateTimePoint() {
        LocalDateTime associatedTime = currentTimePoint.plus(pickRandomMinutesDuration());
        this.currentTimePoint = associatedTime;

        return associatedTime;
    }

    private Duration pickRandomMinutesDuration() {
        return Duration.ofMinutes(random.nextInt(60 * 8));
    }

    private Duration pickRandomDaysDuration() {
        return Duration.ofDays(random.nextInt(365));
    }


}
