package com.kodilla.good.patterns.challenges.flightSearchEngine;

import com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses.FlightsList;
import com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses.RandomTravelGenerator;
import com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses.Flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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

        LocalDateTime now = LocalDateTime.now();
        Flight flight1 = new Flight("SYD", now, "SIN", now, 1);
        Flight flight2 = new Flight("SIN", now, "DBX", now, 1);
        Flight flight3 = new Flight("SIN", now, "FRA", now, 1);
        Flight flight4 = new Flight("DBX", now, "FRA", now, 1);
        Flight flight5 = new Flight("FRA", now, "WAW", now, 1);
        Flight flight6 = new Flight("FRA", now, "MUN", now, 1);
        Flight flight7 = new Flight("DBX", now, "PAL", now, 1);
        Flight flight8 = new Flight("SYD", now, "SIN", now, 1);

        flights = new ArrayList<>(Arrays.asList(flight1, flight2, flight3, flight4, flight5, flight6, flight7, flight8));

        // Finding flights FROM TO
        ArrayList<LinkedList<Flight>> c = FlightsList.findFlightsFromTo("SYD", "WAW", flights);

        for (LinkedList<Flight> e: c) {
            System.out.println(e);
        }

//        // Finding flights FROM THROUGH TO
//        flightsList.findFlightsFromThroughTo("Cracow", "Karlovy Vary", "Trencin");
    }
}
