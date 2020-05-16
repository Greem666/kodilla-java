package com.kodilla.patterns.strategy.social.publishers;

public class TwitterPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "[Twitter] Tweeting about my personal opinions nobody cares about. I. SHALL. CANCEL. YOU.!";
    }
}
