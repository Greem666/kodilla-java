package com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses;

import com.kodilla.good.patterns.challenges.flightSearchEngine.interfaces.IFlight;

import java.util.List;

public class Flight implements IFlight {
    private Location origin;
    private Location destination;
    private List<Location> transferLocations;
    private double cost;

    public Flight(Location origin, Location destination, List<Location> transferLocations, double cost) {
        this.origin = origin;
        this.destination = destination;
        this.transferLocations = transferLocations;
        this.cost = cost;
    }

    @Override
    public Location getOrigin() {
        return origin;
    }

    @Override
    public Location getDestination() {
        return destination;
    }

    @Override
    public List<Location> getTransferLocations() {
        return transferLocations;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "origin=" + origin +
                ", destination=" + destination +
                ", transferLocations=" + transferLocations +
                '}';
    }
}
