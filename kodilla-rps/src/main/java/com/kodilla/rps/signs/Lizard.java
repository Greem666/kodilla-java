package com.kodilla.rps.signs;

import java.util.ArrayList;

public class Lizard extends AbstractSign {
    private final int positionNumber = 4;

    public Lizard() {
        this(true);
    }

    public Lizard(boolean includeComparators) {
        this.name = "Lizard";
        this.weakerThan = new ArrayList<>();
        this.strongerThan = new ArrayList<>();
        if (includeComparators) {
            this.weakerThan.add(new Scissors(false));
            this.weakerThan.add(new Rock(false));
            this.strongerThan.add(new Paper(false));
            this.strongerThan.add(new Spock(false));
        }
    }
}
