package com.kodilla.exception.test;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
import java.util.Random;

public class FlightsScanner {
    private AirportTracker airportTracker;
    private Random random;
    private Map<String, Boolean> flightsMap;

    public FlightsScanner() {
        this.airportTracker = new AirportTracker();
        this.random = new Random();
        this.flightsMap = new AirportTracker().listAllAirports();
    }

    public Flight findFlight(Flight flight) throws RouteNotFoundException{
        String originAirport = flight.getDepartureAirport();
        String destinationAirport = flight.getArrivalAirport();

        if (!flightsMap.keySet().contains(originAirport)) {
            throw new RouteNotFoundException("Origin airport " + originAirport + " was not found on the map!");
        } else if (!flightsMap.keySet().contains(destinationAirport)) {
            throw new RouteNotFoundException("Destination airport " + destinationAirport + " was not found on the map!");
        } else {
            System.out.println(String.format("Happy news! Flight %s from %s to %s will be leaving at %s from gate number %s.",
                    generateFlightNumber(),
                    originAirport,
                    destinationAirport,
                    generateDepartureTime(),
                    generateGateNumber()));
        }
        return flight;
    }

    private String generateFlightNumber() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
        String flightNo = "";

        for (int i = 0; i < 2; i++) {
            flightNo += alphabet[random.nextInt(alphabet.length - 1)];
        }
        for (int i = 0; i < 3; i++) {
            flightNo += random.nextInt(10);
        }
        return flightNo;
    }

    private String generateDepartureTime() {
        int hours = random.nextInt(24);
        int minutes = random.nextInt(60);

        return LocalTime.of(hours, minutes).toString();
    }

    private String generateGateNumber() {
        return String.valueOf(random.nextInt(40));
    }


}
