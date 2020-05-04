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

    public List<Flight> generateRandomFlightRouteBatch(int quantity) {
        List<Flight> flights = new LinkedList<>();
        for (int i = 0; i < quantity; i++) {
            flights.add(generateRandomFlightRoute());
        }

        return flights;
    }

    public Flight generateRandomFlightRoute() {
        List<String> validCitiesCopy = new ArrayList<>(validCities);
        currentTimePoint = LocalDateTime.now().plus(pickRandomDaysDuration());

        // ORIGIN
        Location origin = pickTravelOriginOrDestination(validCitiesCopy, false);

        // TRANSFERS
        int numberOfTransfers = random.nextInt(5);
        List<Location> transfers = new ArrayList<>();
        for (int i = 0; i < numberOfTransfers; i++) {
            transfers.add(pickTravelOriginOrDestination(validCitiesCopy, true));
        }

        // DESTINATION
        Location destination = pickTravelOriginOrDestination(validCitiesCopy, false);

        // COST
        double cost = random.nextDouble() * 1000 * (transfers.size() + 2);

        return new Flight(origin, destination, transfers, cost);
    }

    private Location pickTravelOriginOrDestination(List<String> validCities, boolean isTransfer) {
        String chosenCity = validCities.get(random.nextInt(validCities.size()));
        validCities.remove(chosenCity);

        if (isTransfer) {
            LocalDateTime arrivalTime = generateNextTimePoint();
            LocalDateTime departureTime = generateNextTimePoint();
            return new Location(chosenCity, arrivalTime, departureTime);
        } else {
            LocalDateTime associatedTime = generateNextTimePoint();
            return new Location(chosenCity, associatedTime);
        }
    }

    private LocalDateTime generateNextTimePoint() {
        LocalDateTime associatedTime = currentTimePoint.plus(pickRandomMinutesDuration());
        this.currentTimePoint = associatedTime;

        return associatedTime;
    }

    private Duration pickRandomMinutesDuration() {
        return Duration.ofMinutes(random.nextInt(60 * 5));
    }

    private Duration pickRandomDaysDuration() {
        return Duration.ofDays(random.nextInt(365));
    }


}
