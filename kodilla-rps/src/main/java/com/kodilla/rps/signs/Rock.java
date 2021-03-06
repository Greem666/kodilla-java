package com.kodilla.rps.signs;

import java.util.ArrayList;
import java.util.List;

public class Rock extends AbstractSign {
    private final int positionNumber = 1;

    public Rock() {
        this(true);
    }

    public Rock(boolean includeComparators) {
        this.name = "Rock";
        this.weakerThan = new ArrayList<>();
        this.strongerThan = new ArrayList<>();
        if (includeComparators) {
            this.weakerThan.add(new Paper(false));
            this.weakerThan.add(new Spock(false));
            this.strongerThan.add(new Scissors(false));
            this.strongerThan.add(new Lizard(false));
        }
    }
}
