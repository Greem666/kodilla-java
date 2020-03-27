package com.kodilla.rps.player;

import com.kodilla.rps.signs.ISign;

public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer(String name) {
        super();
        this.name = name;
    }

    public ISign pickASign(int signNumber) {
        return pickASign(signNumber, true);
    }

    public ISign pickASign(int signNumber, boolean verbose) {
        if (signNumber > 0 && signNumber <= this.signFactory.getSignsQuantity()) {
            this.sign = this.signFactory.getSign(signNumber);
        }
        if (verbose) {
            System.out.println(String.format("%s picked a %s.", this.name, this.sign));
        }
        return this.sign;
    }
}
