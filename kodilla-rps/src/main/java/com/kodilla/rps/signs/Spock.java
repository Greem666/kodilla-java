package com.kodilla.rps.signs;

import java.util.ArrayList;

public class Spock extends AbstractSign {
    private final int positionNumber = 5;

    public Spock() {
        this(true);
    }

    public Spock(boolean includeComparators) {
        this.name = "Spock";
        this.weakerThan = new ArrayList<>();
        this.strongerThan = new ArrayList<>();
        if (includeComparators) {
            this.weakerThan.add(new Paper(false));
            this.weakerThan.add(new Lizard(false));
            this.strongerThan.add(new Rock(false));
            this.strongerThan.add(new Scissors(false));
        }
    }
}