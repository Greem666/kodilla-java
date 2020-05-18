package com.kodilla.patterns.builder.bigmac;

public class SauceFactory {
    public static final String STANDARD_SAUCE = "STANDARD";
    public static final String ISLANDS_SAUCE = "100 ISLANDS";
    public static final String BARBECUE_SAUCE = "BARBECUE";

    public static String makeSauce(String sauceType) {
        switch (sauceType) {
            case STANDARD_SAUCE:
                return STANDARD_SAUCE;
            case ISLANDS_SAUCE:
                return ISLANDS_SAUCE;
            case BARBECUE_SAUCE:
                return BARBECUE_SAUCE;
            default:
                throw new IllegalStateException("Unsupported sauce <<" + sauceType + ">>!");
        }
    }
}
