package com.kodilla.good.patterns.challenges.flightSearchEngine.auxClasses;

import com.kodilla.good.patterns.challenges.flightSearchEngine.interfaces.ILocation;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Location implements ILocation {
    private String name;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;

    public Location(String name) {
        this(name, null, null);
    }

    public Location(String name, LocalDateTime arrivalOrDepartureTime) {
        this(name, arrivalOrDepartureTime, arrivalOrDepartureTime);
    }

    public Location(String name, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public Duration getLayoverTime() {
        return Duration.between(this.departureTime, this.arrivalTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return name.equals(location.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                '}';
    }
}
