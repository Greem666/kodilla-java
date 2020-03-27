package com.kodilla.rps;

import com.kodilla.rps.service.RpsManager;

public class RpsRunner {
    public static void main(String[] args) {
        RpsManager rpsManager = new RpsManager();

        rpsManager.runGame();

    }
}
