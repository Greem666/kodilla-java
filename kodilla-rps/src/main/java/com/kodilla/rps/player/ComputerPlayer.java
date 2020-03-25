package com.kodilla.rps.player;

import com.kodilla.rps.signs.ISign;

import java.util.List;
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
        ISign humanPlayerSign = this.signOptions.get(humanChoice);
        int decision = decisionMaker.nextInt(100);
        if (decision < 25) {
            this.sign = pickDrawingSign(humanPlayerSign);
        } else if (decision < 50) {
            this.sign = pickLosingSign(humanPlayerSign);
        } else {
            this.sign = pickWinningSign(humanPlayerSign);
        }
        return this.sign;
    }

    private ISign pickDrawingSign(ISign sign) {
        return sign;
    }

    private ISign pickLosingSign(ISign sign) {
        return this.getSignOptions().values().stream()
                .filter(e -> e.isStrongerThan(sign)!=null)
                .filter(e -> !e.isStrongerThan(sign))
                .collect(Collectors.toList()).get(0);
    }

    private ISign pickWinningSign(ISign sign) {
        return this.getSignOptions().values().stream()
                .filter(e -> e.isStrongerThan(sign)!=null)
                .filter(e -> e.isStrongerThan(sign))
                .collect(Collectors.toList()).get(0);
    }
}
