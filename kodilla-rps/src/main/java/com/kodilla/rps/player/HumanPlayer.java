package com.kodilla.rps.player;

import com.kodilla.rps.signs.ISign;

public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer(String name) {
        super();
        this.name = name;
    }

    public ISign pickASign(int signNumber) {
        if (signNumber > 0 && signNumber <= this.signOptions.size()) {
            this.sign = this.signOptions.get(signNumber);
        }
        return this.sign;
    }
}
