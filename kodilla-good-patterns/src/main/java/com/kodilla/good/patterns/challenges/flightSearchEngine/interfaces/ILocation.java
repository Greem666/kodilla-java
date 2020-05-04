package com.kodilla.good.patterns.challenges.flightSearchEngine.interfaces;

import java.time.LocalDateTime;

public interface ILocation {
    String getName();
    LocalDateTime getArrivalTime();
    LocalDateTime getDepartureTime();
}
