package com.kodilla.good.patterns.challenges.flightSearchEngine;

import com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses.FlightSearchEngine;
import com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses.RandomTravelGenerator;
import com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses.Flight;

import java.util.ArrayList;
import java.util.LinkedList;

public class FlightSearchEngineRunner {

    public static void main(String[] args) {
        ArrayList<Flight> flights = new RandomTravelGenerator().generateRandomFlightRouteBatch(2000);
        FlightSearchEngine searchEngine = new FlightSearchEngine(flights);

        // Finding flights FROM
        ArrayList<Flight> fromFlights = searchEngine.findFlightsFrom("Cracow");
        System.out.println("FLIGHTS FROM CRACOW");
        System.out.println(fromFlights);

        // Finding flights TO
        ArrayList<Flight> toFlights = searchEngine.findFlightsTo("Cracow");
        System.out.println("FLIGHTS TO CRACOW");
        System.out.println(toFlights);

//        // Finding flights FROM THROUGH TO
        ArrayList<LinkedList<Flight>> fromThroughToFlights = searchEngine.findFlightsFromThroughTo("Cracow", "Karlovy Vary", "Nitra");

        System.out.println("FLIGHTS FROM CRACOW, THROUGH KARLOVY VARY, TO NITARA");
        for (LinkedList<Flight> flight: fromThroughToFlights) {
            System.out.println(flight);
        }
    }
}
