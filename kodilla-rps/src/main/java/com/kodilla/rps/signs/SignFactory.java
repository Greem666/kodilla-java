package com.kodilla.rps.signs;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SignFactory {
    private Map<Integer, ISign> signOptions = Stream.of(new Object[][] {
            {1, new Rock()},
            {2, new Paper()},
            {3, new Scissors()},
            {4, new Lizard()},
            {5, new Spock()},
    }).collect(Collectors.toMap(pair -> (Integer)pair[0], pair -> (ISign)pair[1]));

    public ISign getSign(int position) {
        return signOptions.get(position);
    }

    public int getSignsQuantity() {
        return signOptions.size();
    }

    public Map<Integer, ISign> getSignOptions() {
        return signOptions;
    }
}
