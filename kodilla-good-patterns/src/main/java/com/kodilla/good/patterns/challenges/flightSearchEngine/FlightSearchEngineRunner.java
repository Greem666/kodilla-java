package com.kodilla.good.patterns.challenges.flightSearchEngine;

import com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses.FlightsList;
import com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses.RandomTravelGenerator;
import com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses.Flight;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FlightSearchEngineRunner {

    public static void main(String[] args) {
        ArrayList<Flight> flights = new RandomTravelGenerator().generateRandomFlightRouteBatch(2000);
//        FlightsList flightsList = new FlightsList(flights);

        // Finding flights FROM
        ArrayList<Flight> a = FlightsList.findFlightsFrom("Cracow", flights);
        System.out.println(a);

        // Finding flights TO
        ArrayList<Flight> b = FlightsList.findFlightsTo("Cracow", flights);
        System.out.println(b);

        // Finding flights FROM TO
        ArrayList<LinkedList<Flight>> c = FlightsList.findFlightsFromTo("Cracow", "Karlovy Vary", flights);

        for (LinkedList<Flight> e: c) {
            System.out.println(e);
        }

//        // Finding flights FROM THROUGH TO
//        flightsList.findFlightsFromThroughTo("Cracow", "Karlovy Vary", "Trencin");
    }
}
