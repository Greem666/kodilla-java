package com.kodilla.rps.player;

import com.kodilla.rps.signs.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public abstract class AbstractPlayer {
    protected String name;
    protected int winsCount;
    protected ISign sign;
    protected SignFactory signFactory;

    public AbstractPlayer() {
        this.winsCount = 0;
        this.signFactory = new SignFactory();
    }

    public abstract ISign pickASign(int signNumber);

    public void resetSign() {
        this.sign = null;
    }

    public void incrementWinsCount() {
        this.winsCount += 1;
    }

    public String getName() {
        return name;
    }

    public ISign getSign() {
        return this.sign;
    }

    public int getWinsCount() {
        return winsCount;
    }

    public void resetWinsCount() {
        this.winsCount = 0;
    }

    @Override
    public String toString() {
        return "Player: " + this.name + " (wins: " + this.winsCount + ")";
    }
}
