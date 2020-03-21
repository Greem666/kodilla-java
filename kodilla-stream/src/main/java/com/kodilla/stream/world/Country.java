package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country {
    private BigDecimal peopleQuantity;

    public Country(int peopleQuantity) {
        this.peopleQuantity = new BigDecimal(String.valueOf(peopleQuantity));
    }

    public BigDecimal getPeopleQuantity() {
        return this.peopleQuantity;
    }
}
