package com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightsList {
    private List<Flight> availableFlights;
    private Map<Location, List<Flight>> originsMap = new HashMap<>();
    private Map<Location, List<Flight>> destinationsMap = new HashMap<>();

    public FlightsList(List<Flight> availableFlights) {
        this.availableFlights = availableFlights;
        populateOriginsMap();
        populateDestinationsMap();
    }

    public void findFlightsFromThroughTo(String fromCityName, String throughCityName, String toCityName) {
        System.out.println("----> FLIGHTS FROM " + fromCityName.toUpperCase() + " THROUGH " + throughCityName.toUpperCase() + " TO " + toCityName.toUpperCase() + " <----");
        List<Flight> matchingFlights = findFlightsFromTo(fromCityName, toCityName, false);

        matchingFlights = matchingFlights.stream()
                .filter(e -> e.getTransferLocations().contains(new Location(throughCityName)))
                .collect(Collectors.toList());

        printFlightOptions(matchingFlights);
    }

    public List<Flight> findFlightsFromTo(String fromCityName, String toCityName) {
        return findFlightsFromTo(fromCityName, toCityName, true);
    }

    public List<Flight> findFlightsFromTo(String fromCityName, String toCityName, Boolean printResults) {
        List<Flight> matchingFlights = findFlightsToOrFrom(fromCityName, this.originsMap, false);

        matchingFlights = matchingFlights.stream()
                .filter(e -> e.getDestination().equals(new Location(toCityName)))
                .collect(Collectors.toList());

        if (printResults) {
            System.out.println("----> FLIGHTS FROM " + fromCityName.toUpperCase() + " TO " + toCityName.toUpperCase() + " <----");
            printFlightOptions(matchingFlights);
        }

        return matchingFlights;
    }

    public void findFlightsFrom(String cityName) {
        System.out.println("----> FLIGHTS FROM " + cityName.toUpperCase() + " <----");
        findFlightsToOrFrom(cityName, this.originsMap, true);
    }

    public void findFlightsTo(String cityName) {
        System.out.println("----> FLIGHTS TO " + cityName.toUpperCase() + " <----");
        findFlightsToOrFrom(cityName, this.destinationsMap, true);
    }

    private List<Flight> findFlightsToOrFrom(String associatedCityName, Map<Location, List<Flight>> associatedMap, Boolean printResults) {
        List<Flight> matchingFlights = associatedMap.get(new Location(associatedCityName));

        if (printResults) {
            printFlightOptions(matchingFlights);
        }

        return matchingFlights;
    }

    private void populateOriginsMap() {
        this.originsMap = this.availableFlights.stream()
                .collect(Collectors.groupingBy(
                        e -> new Location(e.getOrigin().getName()),
                        Collectors.mapping(e -> e, Collectors.toList())
                        )
                );
    }

    private void populateDestinationsMap() {
        this.destinationsMap = this.availableFlights.stream()
                .collect(Collectors.groupingBy(
                        e -> new Location(e.getDestination().getName()),
                        Collectors.mapping(e -> e, Collectors.toList())
                        )
                );
    }

    private void printFlightOptions(List<Flight> flights) {
        if (flights.isEmpty()) {
            System.out.println("********************");
            System.out.println("No matching flights found...");
            System.out.println("********************\n");
        } else {
            System.out.println(String.format("Found %d flight options:\n", flights.size()));
            int optionNo = 1;
            for (Flight flight: flights) {
                System.out.println("OPTION " + optionNo);
                System.out.println("********************");
                System.out.println(String.format("ORIGIN: %s (departure time: %s)",
                        flight.getOrigin().getName(),
                        flight.getOrigin().getDepartureTime()));

                List<Location> transfers = flight.getTransferLocations();
                if (transfers.size() > 0) {
                    int i = 1;
                    for (Location transfer: transfers) {
                        System.out.println(String.format("TRANSFER %d: %s (arrival time: %s; departure time: %s; total layover time: %s)",
                                i,
                                transfer.getName(),
                                transfer.getArrivalTime(),
                                transfer.getDepartureTime(),
                                transfer.getLayoverTime()));
                        i++;
                    }
                }

                System.out.println(String.format("DESTINATION: %s (arrival time: %s)",
                        flight.getDestination().getName(),
                        flight.getDestination().getArrivalTime()));
                System.out.println(String.format("Total cost: $%.2f", flight.getCost()));
                System.out.println("********************\n");

                optionNo++;
            }
        }
    }

}
