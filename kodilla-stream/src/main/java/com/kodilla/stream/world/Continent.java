package com.kodilla.stream.world;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Continent {
    private Set<Country> countries = new HashSet<>();

    public void addCountry(Country country) {
        countries.add(country);
    }

    public void addCountry(Country... countries) {
        this.countries.addAll(Arrays.asList(countries));
    }

    public Set<Country> getCountries() {
        return countries;
    }
}
