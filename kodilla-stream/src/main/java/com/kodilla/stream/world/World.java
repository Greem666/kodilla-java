package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class World {
    private Set<Continent> continents = new HashSet<>();

    public void addContinent(Continent... continents) {
        this.continents.addAll(Arrays.asList(continents));
    }

    public void addContinent(Continent continent) {
        continents.add(continent);
    }

    public BigDecimal getPeopleQuantity() {
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
