package com.kodilla.patterns.strategy.social.publishers;

public class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "[Snapchat] Sharing pics and videos of stuff, which will probably persist on the interwebz, even though they shouldn`t...";
    }
}
