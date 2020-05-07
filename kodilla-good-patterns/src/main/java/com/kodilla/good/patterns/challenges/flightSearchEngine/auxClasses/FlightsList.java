package com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class FlightsList {
//    private List<Flight> availableFlights;

//    public FlightsList(ArrayList<Flight> availableFlights) {
//        this.availableFlights = availableFlights;
//    }

    private static ArrayList<Flight> alreadyVisited = new ArrayList<>();
    private static ArrayList<LinkedList<Flight>> listOfRoutes = new ArrayList<>();


    public void findFlightsFromThroughTo(String fromCityName, String throughCityName, String toCityName) {
        System.out.println("----> FLIGHTS FROM " + fromCityName.toUpperCase() + " THROUGH " + throughCityName.toUpperCase() + " TO " + toCityName.toUpperCase() + " <----");

    }

    public static ArrayList<LinkedList<Flight>> findFlightsFromTo(String fromCityName, String toCityName, final ArrayList<Flight> flightsList) {
//        System.out.println("----> FLIGHTS FROM " + fromCityName.toUpperCase() + " TO " + toCityName.toUpperCase() + " <----");

        ArrayList<Flight> flightsFrom = findFlightsFrom(fromCityName, flightsList, false);
        ArrayList<Flight> flightsTo = findFlightsTo(toCityName, flightsList, false);

        ArrayList<Flight> intersectingFlights = findIntersectingFlights(flightsFrom, flightsTo);

        if (intersectingFlights.size() > 0) {
            return new ArrayList<LinkedList<Flight>>(Arrays.asList(new LinkedList<Flight>(flightsTo)));
        } else {
            for (Flight flightRoute: flightsTo) {
                LinkedList<Flight> validFlightRoute = new LinkedList<Flight>();

//                RECURSION HERE?

                String departureAirport = flightRoute.getDepartureAirport();
    //                ArrayList<Flight> flightListWithoutCurrentFlightRoute = flightsList.stream()
    //                        .filter(e -> !e.equals(flightRoute))
    //                        .collect(Collectors.toCollection(ArrayList::new));
                if (alreadyVisited.contains(flightRoute) ) {
                    System.out.println(flightRoute + " - already visited, skipping...");
                    continue;
                } else if (flightRoute.getDepartureAirport().equals(toCityName)) {
                    System.out.println(flightRoute + " - cycle detected, skipping...");
                    continue;
                } else {
                    System.out.println(flightRoute + " - valid new path element, continuing search...");
                    alreadyVisited.add(flightRoute);
                    validFlightRoute.add(findFlightsFromTo(fromCityName, departureAirport, flightsList).get(0).get(0));
                    alreadyVisited = new ArrayList<Flight>();
                    System.out.println("Flight route assembled: " + validFlightRoute);
                }

                listOfRoutes.add(validFlightRoute);
            }


        }

        return listOfRoutes;
    }

//    public static ArrayList<LinkedList<Flight>> findFlightsFromTo(String fromCityName, String toCityName, ArrayList<Flight> flightsList) {
//        ArrayList<Flight> flightsFrom = findFlightsFrom(fromCityName, flightsList, false);
//        ArrayList<Flight> flightsTo = findFlightsTo(toCityName, flightsList, false);
//
//        LinkedList<Flight> travelPlan = new LinkedList<>();
//
//        for (Flight startingFlight: flightsFrom) {
//
//        }
//    }

    private static ArrayList<Flight> findIntersectingFlights(ArrayList<Flight> listA, ArrayList<Flight> listB) {
        return listA.stream()
                .filter(listB::contains)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Flight> findFlightsFrom(String cityName, List<Flight> flightsList) {
        return findFlightsFrom(cityName, flightsList, true);
    }

    public static ArrayList<Flight> findFlightsFrom(String cityName, List<Flight> flightsList, boolean printResults) {

        ArrayList<Flight> matchingFlights = flightsList.stream()
                .filter(e -> e.getDepartureAirport().equals(cityName))
//                .map(e -> new LinkedList<Flight>(Collections.singletonList(e)))
                .collect(Collectors.toCollection(ArrayList::new));

        if (printResults) {
            System.out.println("----> FLIGHTS FROM " + cityName.toUpperCase() + " <----");
//            printFlightOptions(matchingFlights);
        }

        return matchingFlights;
    }

    public static ArrayList<Flight> findFlightsTo(String cityName, List<Flight> flightsList) {
        return findFlightsTo(cityName, flightsList, true);
    }

    public static ArrayList<Flight> findFlightsTo(String cityName, List<Flight> flightsList, boolean printResults) {

        ArrayList<Flight> matchingFlights = flightsList.stream()
                .filter(e -> e.getArrivalAirport().equals(cityName))
//                .map(e -> new LinkedList<Flight>(Collections.singletonList(e)))
                .collect(Collectors.toCollection(ArrayList::new));

        if (printResults) {
            System.out.println("----> FLIGHTS TO " + cityName.toUpperCase() + " <----");
//            printFlightOptions(matchingFlights);
        }

        return matchingFlights;
    }

//    private void printFlightOptions(List<Flight> flights) {
//        if (flights.isEmpty()) {
//            System.out.println("********************");
//            System.out.println("No matching flights found...");
//            System.out.println("********************\n");
//        } else {
//            System.out.println(String.format("Found %d flight options:\n", flights.size()));
//            int optionNo = 1;
//            for (Flight flight: flights) {
//                System.out.println("OPTION " + optionNo);
//                System.out.println("********************");
//                System.out.println(String.format("ORIGIN: %s (departure time: %s)",
//                        flight.getDepartureAirport().getName(),
//                        flight.getDepartureAirport().getDepartureTime()));
//
//                List<Location> transfers = flight.getTransferLocations();
//                if (transfers.size() > 0) {
//                    int i = 1;
//                    for (Location transfer: transfers) {
//                        System.out.println(String.format("TRANSFER %d: %s (arrival time: %s; departure time: %s; total layover time: %s)",
//                                i,
//                                transfer.getName(),
//                                transfer.getArrivalTime(),
//                                transfer.getDepartureTime(),
//                                transfer.getLayoverTime()));
//                        i++;
//                    }
//                }
//
//                System.out.println(String.format("DESTINATION: %s (arrival time: %s)",
//                        flight.getArrivalAirport().getName(),
//                        flight.getArrivalAirport().getArrivalTime()));
//                System.out.println(String.format("Total cost: $%.2f", flight.getCost()));
//                System.out.println("********************\n");
//
//                optionNo++;
//            }
//        }
//    }

}
