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

    public ISign pickASign(int signNumber) {
        return pickASign(signNumber, true);
    }

    public ISign pickASign(int humanChoice, boolean verbose) {
        ISign humanPlayerSign = this.signFactory.getSign(humanChoice);
        int decision = decisionMaker.nextInt(100);
        if (decision < 25) {
            this.sign = pickDrawingSign(humanPlayerSign);
        } else if (decision < 50) {
            this.sign = pickLosingSign(humanPlayerSign);
        } else {
            this.sign = pickWinningSign(humanPlayerSign);
        }
        if (verbose) {
            System.out.println(String.format("%s picked a %s (rolled %d / 100).", this.name, this.sign, decision));
        }
        return this.sign;
    }

    private ISign pickDrawingSign(ISign sign) {
        return sign;
    }

    private ISign pickLosingSign(ISign sign) {
        List<ISign> losingSigns = this.signFactory.getSignOptions().values().stream()
                .filter(e -> e.isStrongerThan(sign)!=null)
                .filter(e -> !e.isStrongerThan(sign))
                .collect(Collectors.toList());
        return losingSigns.get(decisionMaker.nextInt(losingSigns.size()));
    }

    private ISign pickWinningSign(ISign sign) {
        List<ISign> winningSigns = this.signFactory.getSignOptions().values().stream()
                .filter(e -> e.isStrongerThan(sign)!=null)
                .filter(e -> e.isStrongerThan(sign))
                .collect(Collectors.toList());
        return winningSigns.get(decisionMaker.nextInt(winningSigns.size()));
    }
}
