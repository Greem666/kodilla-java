package com.kodilla.rps.signs;

import java.util.ArrayList;
import java.util.List;

public class Scissors extends AbstractSign {
    private final int positionNumber = 3;

    public Scissors() {
        this(true);
    }

    public Scissors(boolean includeComparators) {
        this.name = "Scissors";
        this.weakerThan = new ArrayList<>();
        this.strongerThan = new ArrayList<>();
        if (includeComparators) {
            this.weakerThan.add(new Rock(false));
            this.weakerThan.add(new Spock(false));
            this.strongerThan.add(new Paper(false));
            this.strongerThan.add(new Lizard(false));
        }
    }
}
