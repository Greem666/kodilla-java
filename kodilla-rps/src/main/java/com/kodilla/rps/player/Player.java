package com.kodilla.rps.player;

import com.kodilla.rps.signs.ISign;

public class Player extends AbstractPlayer {

    public Player(String name) {
        super();
        this.name = name;
        this.winsCount = 0;
    }

    public ISign pickASign(int signNumber) {
        return this.signOptions.get(signNumber);
    }
}
