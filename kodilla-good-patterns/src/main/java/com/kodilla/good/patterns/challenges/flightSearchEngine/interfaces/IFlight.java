package com.kodilla.good.patterns.challenges.flightSearchEngine.interfaces;

import com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses.Location;

import java.util.List;

public interface IFlight {
    Location getOrigin();
    Location getDestination();
    List<Location> getTransferLocations();
}
