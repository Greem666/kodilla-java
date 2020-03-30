package com.kodilla.exception.test;

import java.io.IOException;

public class FlightScannerRunner {
    public static void main(String[] args) throws IOException {
        Flight flight1 = new Flight("Gdansk Airport", "Krakow Airport");
        Flight flight2 = new Flight("Warsaw Airport", "Lodz Airport");
        Flight flight3 = new Flight("Wroclaw Airport", "Kiev (Zhuliany) International Airport");
        Flight flight4 = new Flight("Poznan Airport", "Munich Airport");

        FlightsScanner flightScanner = new FlightsScanner();

        for (Flight flight: new Flight[]{flight1, flight2, flight3, flight4}) {
            try {
                flightScanner.findFlight(flight);
            } catch (RouteNotFoundException e) {
                System.out.println(String.format("No flight from %s to %s has been found!", flight.getDepartureAirport(), flight.getArrivalAirport()));
            }
        }
    }
}
