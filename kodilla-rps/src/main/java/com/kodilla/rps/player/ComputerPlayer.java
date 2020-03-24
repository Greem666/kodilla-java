package com.kodilla.rps.player;

import com.kodilla.rps.signs.ISign;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class ComputerPlayer extends AbstractPlayer {
    private static Random decisionMaker = new Random();

    public ComputerPlayer() {
        super();
        this.name = "Computer";
    }

    public ISign pickASign(int humanChoice) {
        ISign humanPlayersSign = this.signOptions.get(humanChoice);
        int decision = decisionMaker.nextInt(100);
        if (decision < 25) {
            return pickDrawSign(humanPlayersSign);
        } else if (decision < 50) {
            return pickLoseSign(humanPlayersSign);
        } else {
            return pickWinSign(humanPlayersSign);
        }
    }

    private ISign pickDrawSign(ISign sign) {
        return sign;
    }

    private ISign pickLoseSign(ISign sign) {
        return this.signOptions.entrySet().stream()
                .filter(e -> !e.getValue().isStrongerThan(sign))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList()).get(0);
    }

    private ISign pickWinSign(ISign sign) {
        return this.signOptions.entrySet().stream()
                .filter(e -> e.getValue().isStrongerThan(sign))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList()).get(0);
    }
}
