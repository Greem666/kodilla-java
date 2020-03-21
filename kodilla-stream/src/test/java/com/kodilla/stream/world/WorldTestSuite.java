package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        // Given
        World world = new World();
        Continent europe = new Continent();
        Continent africa = new Continent();
        Continent asia = new Continent();
        Continent northAmerica = new Continent();
        Continent southAmerica = new Continent();
        Continent australiaContinent = new Continent();
        Continent antarcticaContinent = new Continent();
        Country poland = new Country(38_000_000);
        Country germany = new Country(83_000_000);
        Country france = new Country(67_000_000);
        Country morocco = new Country(36_000_000);
        Country egypt = new Country(98_000_000);
        Country libya = new Country(7_000_000);
        Country china = new Country(1_400_000_000);
        Country india = new Country(1_350_000_000);
        Country singapore = new Country(5_600_000);
        Country usa = new Country(327_000_000);
        Country canada = new Country(38_000_000);
        Country greenland = new Country(56_000);
        Country brazil = new Country(209_000_000);
        Country argentina = new Country(44_000_000);
        Country colombia = new Country(50_000_000);
        Country australiaCountry = new Country(25_000_000);
        Country antarcticaTerritory = new Country(5_000);

        // When
        europe.addCountry(poland, germany, france);
        africa.addCountry(morocco, egypt, libya);
        asia.addCountry(china, india, singapore);
        northAmerica.addCountry(usa, canada, greenland);
        southAmerica.addCountry(brazil, colombia, argentina);
        australiaContinent.addCountry(australiaCountry);
        antarcticaContinent.addCountry(antarcticaTerritory);
        world.addContinent(europe, africa, asia, northAmerica, southAmerica, australiaContinent, antarcticaContinent);

        // Then
        Assert.assertEquals(new BigDecimal("3777661000"), world.getPeopleQuantity());
    }
}
