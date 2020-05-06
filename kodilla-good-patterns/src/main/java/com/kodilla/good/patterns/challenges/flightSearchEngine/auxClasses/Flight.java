package com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {
    private String departureAirport;
    private LocalDateTime departureDateTime;
    private String arrivalAirport;
    private LocalDateTime arrivalDateTime;
    private double cost;

    public Flight(String departureAirport, LocalDateTime departureDateTime, String arrivalAirport, LocalDateTime arrivalDateTime, double cost) {
        this.departureAirport = departureAirport;
        this.departureDateTime = departureDateTime;
        this.arrivalAirport = arrivalAirport;
        this.arrivalDateTime = arrivalDateTime;
        this.cost = cost;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public Duration getTravelTime() {
        return Duration.between(arrivalDateTime, departureDateTime);
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return departureAirport.equals(flight.departureAirport) &&
                departureDateTime.equals(flight.departureDateTime) &&
                arrivalAirport.equals(flight.arrivalAirport) &&
                arrivalDateTime.equals(flight.arrivalDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureAirport, departureDateTime, arrivalAirport, arrivalDateTime);
    }
}
