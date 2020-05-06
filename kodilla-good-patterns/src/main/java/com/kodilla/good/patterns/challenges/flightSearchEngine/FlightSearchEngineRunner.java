package com.kodilla.good.patterns.challenges.flightSearchEngine;

import com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses.FlightsList;
import com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses.RandomTravelGenerator;
import com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses.Flight;

import java.util.List;

public class FlightSearchEngineRunner {

    public static void main(String[] args) {
        List<Flight> flights = new RandomTravelGenerator().generateRandomFlightRouteBatch(2000);
        FlightsList flightsList = new FlightsList(flights);

        // Finding flights FROM
        flightsList.findFlightsFrom("Cracow");

        // Finding flights TO
        flightsList.findFlightsTo("Cracow");

        // Finding flights FROM TO
        flightsList.findFlightsFromTo("Cracow", "Karlovy Vary");

        // Finding flights FROM THROUGH TO
        flightsList.findFlightsFromThroughTo("Cracow", "Karlovy Vary", "Trencin");
    }
}
