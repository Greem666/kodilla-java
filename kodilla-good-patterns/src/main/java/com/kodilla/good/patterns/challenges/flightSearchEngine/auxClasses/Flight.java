package com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {
    private String departureAirport;
    private String arrivalAirport;

    public Flight(String departureAirport, String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return departureAirport.equals(flight.departureAirport) &&
                arrivalAirport.equals(flight.arrivalAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureAirport, arrivalAirport);
    }

    @Override
    public String toString() {
        return "[" + departureAirport + " -> " + arrivalAirport + "]";
    }
}
