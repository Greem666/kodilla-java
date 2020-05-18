package com.kodilla.patterns.builder.bigmac;

public class BunFactory {
    public static final String SESAME_BUN = "SESAME";
    public static final String PLAIN_BUN = "PLAIN";
    public static final String BRIOCHE_BUN = "BRIOCHE";

    public static String makeBun(String bunType) {
        switch (bunType) {
            case SESAME_BUN:
                return SESAME_BUN;
            case PLAIN_BUN:
                return PLAIN_BUN;
            case BRIOCHE_BUN:
                return BRIOCHE_BUN;
            default:
                throw new IllegalStateException("Unsupported bun type <<" + bunType + ">>!");
        }
    }
}
