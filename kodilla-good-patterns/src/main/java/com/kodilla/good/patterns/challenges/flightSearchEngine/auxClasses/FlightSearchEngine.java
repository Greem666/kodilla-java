package com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses;

import java.util.*;
import java.util.stream.Collectors;

public class FlightSearchEngine {
    private List<Flight> availableFlights;
    private ArrayList<Flight> usedFlights = new ArrayList<>();
    private ArrayList<String> visitedCities = new ArrayList<>();
    public static int MAX_TRANSFERS = 2;


    public FlightSearchEngine(ArrayList<Flight> availableFlights) {
        this.availableFlights = availableFlights;
    }


    public ArrayList<LinkedList<Flight>> findFlightsFromThroughTo(String fromCityName, String throughCityName, String toCityName) {

        ArrayList<LinkedList<Flight>> firstHalfTrip = findFlightsFromTo(fromCityName, throughCityName);
        firstHalfTrip = applyTransferLimitFilter(firstHalfTrip);

        ArrayList<LinkedList<Flight>> secondHalfTrip = findFlightsFromTo(throughCityName, toCityName);
        secondHalfTrip = applyTransferLimitFilter(secondHalfTrip);

        ArrayList<LinkedList<Flight>> finalItinerary = new ArrayList<>();

        for (LinkedList<Flight> firstHalfTripOption: firstHalfTrip) {
            for (LinkedList<Flight> secondHalfTripOption: secondHalfTrip) {
                LinkedList<Flight> tmp = new LinkedList<>(firstHalfTripOption);
                tmp.addAll(secondHalfTripOption);
                finalItinerary.add(tmp);
            }
        }

        return finalItinerary;
    }

    private ArrayList<LinkedList<Flight>> applyTransferLimitFilter(ArrayList<LinkedList<Flight>> flightOptions) {
        return flightOptions.stream()
                .filter(e -> e.size() <= MAX_TRANSFERS)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<LinkedList<Flight>> findFlightsFromTo(String fromCityName, String toCityName) {
        // Reset of usedFlights&visitedCities cannot be done inside of findFlightsFromToEngine(),
        //   since it causes recursion to end up in a StackOverflow exception.
        ArrayList<LinkedList<Flight>> matchingFlights = findFlightsFromToEngine(fromCityName, toCityName);
        this.usedFlights = new ArrayList<>();
        this.visitedCities = new ArrayList<>();

        return matchingFlights;
    }

    private ArrayList<LinkedList<Flight>> findFlightsFromToEngine(String fromCityName, String toCityName) {
        ArrayList<Flight> flightsFrom = findFlightsFrom(fromCityName, false);
        ArrayList<Flight> flightsTo = findFlightsTo(toCityName, false);

        ArrayList<LinkedList<Flight>> routes = new ArrayList<>();

        for (Flight flight: flightsFrom) {
            routes.add(new LinkedList<Flight>(Collections.singletonList(flight)));

            if (flightsTo.contains(flight)) {
                return routes.stream()
                        .filter(e -> e.get(0).getDepartureAirport().equals(fromCityName))
                        .filter(e -> e.get(e.size()-1).getArrivalAirport().equals(toCityName))
                        .collect(Collectors.toCollection(ArrayList::new));
            } else {

                if (!usedFlights.contains(flight) && !visitedCities.contains(flight.getDepartureAirport())) {
                    usedFlights.add(flight);
                    visitedCities.add(flight.getDepartureAirport());

                    String transferFromCityName = flight.getArrivalAirport();
                    ArrayList<LinkedList<Flight>> recursiveRouteOptions = findFlightsFromToEngine(transferFromCityName, toCityName);

                    if (!recursiveRouteOptions.isEmpty()) {
                        LinkedList<Flight> prevRoute = routes.get(routes.size()-1);
                        routes.remove(prevRoute);

                        for (LinkedList<Flight> flightOption: recursiveRouteOptions) {
                            LinkedList<Flight> updatedRoute = new LinkedList<>(prevRoute);
                            updatedRoute.addAll(flightOption);

                            routes.add(updatedRoute);
                        }
                    }
                }
            }
        }

        return routes;
    }

    public ArrayList<Flight> findFlightsFrom(String cityName) {
        return findFlightsFrom(cityName, true);
    }

    public ArrayList<Flight> findFlightsFrom(String cityName, boolean printResults) {

        ArrayList<Flight> matchingFlights = this.availableFlights.stream()
                .filter(e -> e.getDepartureAirport().equals(cityName))
                .collect(Collectors.toCollection(ArrayList::new));

        return matchingFlights;
    }

    public ArrayList<Flight> findFlightsTo(String cityName) {
        return findFlightsTo(cityName, true);
    }

    public ArrayList<Flight> findFlightsTo(String cityName, boolean printResults) {

        ArrayList<Flight> matchingFlights = this.availableFlights.stream()
                .filter(e -> e.getArrivalAirport().equals(cityName))
                .collect(Collectors.toCollection(ArrayList::new));

        return matchingFlights;
    }
}
