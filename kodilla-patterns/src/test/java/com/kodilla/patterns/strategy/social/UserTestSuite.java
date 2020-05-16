package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;
import com.kodilla.patterns.strategy.social.users.Millenials;
import com.kodilla.patterns.strategy.social.users.User;
import com.kodilla.patterns.strategy.social.users.YGeneration;
import com.kodilla.patterns.strategy.social.users.ZGeneration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTestSuite {
    @Before
    public void beforeEachTest() {
        System.out.print("Testing: ");
    }

    @After
    public void afterEachTest() {
        System.out.println("Test complete.\n");
    }

    @Test
    public void testDefaultSharingStrategies() {
        // Given
        User millenial = new Millenials("A silly Millenial");
        User generationY = new YGeneration("Also a Millenial, equally silly");
        User generationZ = new ZGeneration("A new hope");

        System.out.println("testDefaultSharingStrategies");

        // When
        String millenialShares = millenial.sharePost();
        System.out.println("Millenial shares: " + millenialShares + " (and nobody cares)");
        String generationYShares = generationY.sharePost();
        System.out.println("Gen Y'er shares: " + generationYShares + " (and STILL nobody cares)");
        String generationZShares = generationZ.sharePost();
        System.out.println("Gen Z'er shares: " + generationZShares + " (and it might have some merit)");

        // Then
        Assert.assertEquals("[Facebook] sharing my irrelevant thoughts on a website nobody cares about...", millenialShares);
        Assert.assertEquals("[Twitter] Tweeting about my personal opinions nobody cares about. I. SHALL. CANCEL. YOU.!", generationYShares);
        Assert.assertEquals("[Snapchat] Sharing pics and videos of stuff, which will probably persist on the interwebz, even though they shouldn`t...", generationZShares);
    }

    @Test
    public void testIndividualSharingStrategies() {
        // Given
        User millenial = new Millenials("A silly Millenial");

        System.out.println("testIndividualSharingStrategies");

        // When
        String millenialShares = millenial.sharePost();
        System.out.println("Millenial shares: " + millenialShares + " (and nobody cares)");

        millenial.setSocialPublisher(new TwitterPublisher());

        String millenialNowShares = millenial.sharePost();
        System.out.println("Millenial now shares: " + millenialNowShares + " (and nobody cares)");

        // Then
        Assert.assertEquals("[Facebook] sharing my irrelevant thoughts on a website nobody cares about...", millenialShares);
        Assert.assertEquals("[Twitter] Tweeting about my personal opinions nobody cares about. I. SHALL. CANCEL. YOU.!", millenialNowShares);
    }
}
