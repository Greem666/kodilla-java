package com.kodilla.rps.signs;

public interface ISign {
    // -1 if weaker, 0 if equal, 1 if stronger
    Boolean isStrongerThan(ISign sign);
    // Getter for weakness/strength comparison
    String getName();
}
