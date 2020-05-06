package com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses;

import java.util.*;
import java.util.stream.Collectors;

public class FlightsList {
    private List<Flight> availableFlights;

    public FlightsList(ArrayList<Flight> availableFlights) {
        this.availableFlights = availableFlights;
    }

    public void findFlightsFromThroughTo(String fromCityName, String throughCityName, String toCityName) {
        System.out.println("----> FLIGHTS FROM " + fromCityName.toUpperCase() + " THROUGH " + throughCityName.toUpperCase() + " TO " + toCityName.toUpperCase() + " <----");

    }

    public ArrayList<LinkedList<Flight>> findFlightsFromTo(String fromCityName, String toCityName) {
        System.out.println("----> FLIGHTS FROM " + fromCityName.toUpperCase() + " TO " + toCityName.toUpperCase() + " <----");

        List<Flight> flightsFrom = findFlightsFrom(fromCityName, this.availableFlights, false);
        List<Flight> flightsTo = findFlightsTo(toCityName, this.availableFlights, false);

        ArrayList<LinkedList<Flight>> intersectingFlights = findIntersectingFlights(flightsFrom, flightsTo);

        if (intersectingFlights.size() > 0) {
            return intersectingFlights;
        } else {
            ArrayList<LinkedList<Flight>> flightRoutes = new ArrayList<>(
                    flightsFrom.stream()
                            .map(e -> new LinkedList<Flight>(Collections.singletonList(e)))
                            .collect(Collectors.toCollection(ArrayList::new))
            );

            for (LinkedList<Flight> flightRoute: flightRoutes) {

//                RECURSION HERE?

                String lastStop = flightRoute.get(flightRoute.size()-1).getArrivalAirport();
                findFlightsFromTo(lastStop, toCityName);


            }

        }
    }

    private ArrayList<LinkedList<Flight>> findIntersectingFlights(List<Flight> listA, List<Flight> listB) {
        return listA.stream()
                .filter(listB::contains)
                .map(e -> new LinkedList<Flight>(Collections.singletonList(e)))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void findFlightsFrom(String cityName) {
        findFlightsFrom(cityName, this.availableFlights, true);
    }

    public List<Flight> findFlightsFrom(String cityName, List<Flight> flightsList, boolean printResults) {

        List<Flight> matchingFlights = flightsList.stream()
                .filter(e -> e.getDepartureAirport().equals(cityName))
                .collect(Collectors.toCollection(ArrayList::new));

        if (printResults) {
            System.out.println("----> FLIGHTS FROM " + cityName.toUpperCase() + " <----");
            printFlightOptions(matchingFlights);
        }

        return matchingFlights;
    }

    public void findFlightsTo(String cityName) {
        findFlightsTo(cityName, this.availableFlights, true);
    }

    public List<Flight> findFlightsTo(String cityName, List<Flight> flightsList, boolean printResults) {

        List<Flight> matchingFlights = flightsList.stream()
                .filter(e -> e.getArrivalAirport().equals(cityName))
                .collect(Collectors.toCollection(ArrayList::new));

        if (printResults) {
            System.out.println("----> FLIGHTS TO " + cityName.toUpperCase() + " <----");
            printFlightOptions(matchingFlights);
        }

        return matchingFlights;
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
                        flight.getDepartureAirport().getName(),
                        flight.getDepartureAirport().getDepartureTime()));

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
                        flight.getArrivalAirport().getName(),
                        flight.getArrivalAirport().getArrivalTime()));
                System.out.println(String.format("Total cost: $%.2f", flight.getCost()));
                System.out.println("********************\n");

                optionNo++;
            }
        }
    }

}
