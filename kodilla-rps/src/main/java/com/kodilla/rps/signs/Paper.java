package com.kodilla.rps.signs;

import java.util.ArrayList;

public class Paper extends AbstractSign {

    public Paper() {
        this(true);
    }

    public Paper(boolean includeComparators) {
        this.name = "Paper";
        this.weakerThan = new ArrayList<>();
        this.strongerThan = new ArrayList<>();
        if (includeComparators) {
            this.weakerThan.add(new Scissors(false));
            this.strongerThan.add(new Rock(false));
        }
    }
}
