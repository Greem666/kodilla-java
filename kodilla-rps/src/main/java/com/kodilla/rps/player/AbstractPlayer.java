package com.kodilla.rps.player;

import com.kodilla.rps.signs.ISign;
import com.kodilla.rps.signs.Paper;
import com.kodilla.rps.signs.Rock;
import com.kodilla.rps.signs.Scissors;

import java.util.HashMap;
import java.util.List;

public abstract class AbstractPlayer {
    protected String name;
    protected int winsCount;
    protected ISign sign;
    protected final HashMap<Integer, ISign> signOptions;

    public AbstractPlayer() {
        this.winsCount = 0;
        this.signOptions = new HashMap<>();
        signOptions.put(1, new Rock());
        signOptions.put(2, new Paper());
        signOptions.put(3, new Scissors());
    }

    public HashMap<Integer, ISign> getSignOptions() {
        return new HashMap<Integer, ISign>(signOptions);
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

    @Override
    public String toString() {
        return "Player: " + this.name + " (wins: " + this.winsCount + ")";
    }
}
