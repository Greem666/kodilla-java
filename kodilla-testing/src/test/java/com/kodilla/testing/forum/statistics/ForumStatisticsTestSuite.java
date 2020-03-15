package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {
    ForumStatistics forumStatistics;
    Statistics statistics;
    List<String> userNames;
    double allowedDelta = 0.001;

    /**
     * Aux method for easy variable this.userNames List<String> initialization
     */
    public void initializeUserNamesList(int userCount) {
        this.userNames = new ArrayList<>();
        for (int i = 1; i <= userCount; i++) {
            this.userNames.add("User" + i);
        }
    }

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Starting test suite for ForumStatistics");
    }

    @Before
    public void beforeEachTest() {
        System.out.print("Starting test: ");

        this.forumStatistics = new ForumStatistics();
        this.statistics = mock(Statistics.class);
        initializeUserNamesList(10);

        // Default mocked statistics behaviour
        when(statistics.postsCount()).thenReturn(10_000);
        when(statistics.commentsCount()).thenReturn(10_000);
        when(statistics.userNames()).thenReturn(this.userNames);
    }

    @After
    public void afterEachTest() {
        System.out.println("Test done.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests for ForumStatistics are done.");
    }

    @Test
    public void testCalculateAdvStatistics() {
        System.out.print("calculateAdvStatistics()... ");

        // Given
        // this.forumStatistics, this.userNames and this.statistics
        //   Mockito behaviour defined in beforeEachTest()
        this.forumStatistics.calculateAdvStatistics(this.statistics);

        // When
        int expectedUsersCount = 10;
        int expectedPostsCount = 10_000;
        int expectedCommentsCount = 10_000;
        double expectedAvgPostsPerUser = 1_000.0;
        double expectedAvgCommentsPerUser = 1_000.0;
        double expectedAvgCommentsPerPost = 1.0;

        // Then
        Assert.assertEquals(expectedUsersCount, this.forumStatistics.getUsersCount());
        Assert.assertEquals(expectedPostsCount, this.forumStatistics.getPostsCount());
        Assert.assertEquals(expectedCommentsCount, this.forumStatistics.getCommentsCount());
        Assert.assertEquals(expectedAvgPostsPerUser, this.forumStatistics.getAvgPostsPerUser(), this.allowedDelta);
        Assert.assertEquals(expectedAvgCommentsPerUser, this.forumStatistics.getAvgCommentsPerUser(), this.allowedDelta);
        Assert.assertEquals(expectedAvgCommentsPerPost, this.forumStatistics.getAvgCommentsPerPost(), this.allowedDelta);
    }

    @Test
    public void testCalculateAdvStatisticsZeroPosts() {
        System.out.print("calculateAdvStatistics() zero posts... ");

        // Given
        // this.forumStatistics, this.userNames and this.statistics
        //   Mockito behaviour defined in before(), except for:
        when(statistics.postsCount()).thenReturn(0);
        this.forumStatistics.calculateAdvStatistics(this.statistics);

        // When
        int expectedUsersCount = 10;
        int expectedPostsCount = 0;
        int expectedCommentsCount = 10_000;
        double expectedAvgPostsPerUser = 0.0;
        double expectedAvgCommentsPerUser = 1_000.0;
        double expectedAvgCommentsPerPost = 0.0;

        // Then
        Assert.assertEquals(expectedUsersCount, this.forumStatistics.getUsersCount());
        Assert.assertEquals(expectedPostsCount, this.forumStatistics.getPostsCount());
        Assert.assertEquals(expectedCommentsCount, this.forumStatistics.getCommentsCount());
        Assert.assertEquals(expectedAvgPostsPerUser, this.forumStatistics.getAvgPostsPerUser(), this.allowedDelta);
        Assert.assertEquals(expectedAvgCommentsPerUser, this.forumStatistics.getAvgCommentsPerUser(), this.allowedDelta);
        Assert.assertEquals(expectedAvgCommentsPerPost, this.forumStatistics.getAvgCommentsPerPost(), this.allowedDelta);
    }

    @Test
    public void testCalculateAdvStatisticsThousandPosts() {
        System.out.print("calculateAdvStatistics() 1000 posts... ");

        // Given
        // this.forumStatistics, this.userNames and this.statistics
        //   Mockito behaviour defined in before(), except for:
        when(statistics.postsCount()).thenReturn(1_000);
        this.forumStatistics.calculateAdvStatistics(this.statistics);

        // When
        int expectedUsersCount = 10;
        int expectedPostsCount = 1_000;
        int expectedCommentsCount = 10_000;
        double expectedAvgPostsPerUser = 100.0;
        double expectedAvgCommentsPerUser = 1_000.0;
        double expectedAvgCommentsPerPost = 10.0;

        // Then
        Assert.assertEquals(expectedUsersCount, this.forumStatistics.getUsersCount());
        Assert.assertEquals(expectedPostsCount, this.forumStatistics.getPostsCount());
        Assert.assertEquals(expectedCommentsCount, this.forumStatistics.getCommentsCount());
        Assert.assertEquals(expectedAvgPostsPerUser, this.forumStatistics.getAvgPostsPerUser(), this.allowedDelta);
        Assert.assertEquals(expectedAvgCommentsPerUser, this.forumStatistics.getAvgCommentsPerUser(), this.allowedDelta);
        Assert.assertEquals(expectedAvgCommentsPerPost, this.forumStatistics.getAvgCommentsPerPost(), this.allowedDelta);
    }

    @Test
    public void testCalculateAdvStatisticsZeroComments() {
        System.out.print("calculateAdvStatistics() 0 comments... ");

        // Given
        // this.forumStatistics, this.userNames and this.statistics
        //   Mockito behaviour defined in before(), except for:
        when(statistics.commentsCount()).thenReturn(0);
        this.forumStatistics.calculateAdvStatistics(this.statistics);

        // When
        int expectedUsersCount = 10;
        int expectedPostsCount = 10_000;
        int expectedCommentsCount = 0;
        double expectedAvgPostsPerUser = 1_000.0;
        double expectedAvgCommentsPerUser = 0.0;
        double expectedAvgCommentsPerPost = 0.0;

        // Then
        Assert.assertEquals(expectedUsersCount, this.forumStatistics.getUsersCount());
        Assert.assertEquals(expectedPostsCount, this.forumStatistics.getPostsCount());
        Assert.assertEquals(expectedCommentsCount, this.forumStatistics.getCommentsCount());
        Assert.assertEquals(expectedAvgPostsPerUser, this.forumStatistics.getAvgPostsPerUser(), this.allowedDelta);
        Assert.assertEquals(expectedAvgCommentsPerUser, this.forumStatistics.getAvgCommentsPerUser(), this.allowedDelta);
        Assert.assertEquals(expectedAvgCommentsPerPost, this.forumStatistics.getAvgCommentsPerPost(), this.allowedDelta);
    }

    @Test
    public void testCalculateAdvStatisticsMorePostsThanComments() {
        System.out.print("calculateAdvStatistics() more posts than comments... ");

        // Given
        // this.forumStatistics, this.userNames and this.statistics
        //   Mockito behaviour defined in before(), except for:
        when(statistics.commentsCount()).thenReturn(100);
        this.forumStatistics.calculateAdvStatistics(this.statistics);

        // When
        int expectedUsersCount = 10;
        int expectedPostsCount = 10_000;
        int expectedCommentsCount = 100;
        double expectedAvgPostsPerUser = 1_000.0;
        double expectedAvgCommentsPerUser = 10.0;
        double expectedAvgCommentsPerPost = 0.01;

        // Then
        Assert.assertEquals(expectedUsersCount, this.forumStatistics.getUsersCount());
        Assert.assertEquals(expectedPostsCount, this.forumStatistics.getPostsCount());
        Assert.assertEquals(expectedCommentsCount, this.forumStatistics.getCommentsCount());
        Assert.assertEquals(expectedAvgPostsPerUser, this.forumStatistics.getAvgPostsPerUser(), this.allowedDelta);
        Assert.assertEquals(expectedAvgCommentsPerUser, this.forumStatistics.getAvgCommentsPerUser(), this.allowedDelta);
        Assert.assertEquals(expectedAvgCommentsPerPost, this.forumStatistics.getAvgCommentsPerPost(), this.allowedDelta);
    }

    @Test
    public void testCalculateAdvStatisticsMoreCommentsThanPosts() {
        System.out.print("calculateAdvStatistics() more comments than posts... ");

        // Given
        // this.forumStatistics, this.userNames and this.statistics
        //   Mockito behaviour defined in before(), except for:
        when(statistics.commentsCount()).thenReturn(1_000_000);
        this.forumStatistics.calculateAdvStatistics(this.statistics);

        // When
        int expectedUsersCount = 10;
        int expectedPostsCount = 10_000;
        int expectedCommentsCount = 1_000_000;
        double expectedAvgPostsPerUser = 1_000.0;
        double expectedAvgCommentsPerUser = 100_000.0;
        double expectedAvgCommentsPerPost = 100.0;

        // Then
        Assert.assertEquals(expectedUsersCount, this.forumStatistics.getUsersCount());
        Assert.assertEquals(expectedPostsCount, this.forumStatistics.getPostsCount());
        Assert.assertEquals(expectedCommentsCount, this.forumStatistics.getCommentsCount());
        Assert.assertEquals(expectedAvgPostsPerUser, this.forumStatistics.getAvgPostsPerUser(), this.allowedDelta);
        Assert.assertEquals(expectedAvgCommentsPerUser, this.forumStatistics.getAvgCommentsPerUser(), this.allowedDelta);
        Assert.assertEquals(expectedAvgCommentsPerPost, this.forumStatistics.getAvgCommentsPerPost(), this.allowedDelta);
    }

    @Test
    public void testCalculateAdvStatisticsZeroUsers() {
        System.out.print("calculateAdvStatistics() zero users... ");

        // Given
        // this.forumStatistics, this.userNames and this.statistics
        //   Mockito behaviour defined in before(), except for:
        initializeUserNamesList(0);
        when(statistics.userNames()).thenReturn(this.userNames);
        this.forumStatistics.calculateAdvStatistics(this.statistics);

        // When
        int expectedUsersCount = 0;
        int expectedPostsCount = 10_000;
        int expectedCommentsCount = 10_000;
        double expectedAvgPostsPerUser = 0.0;
        double expectedAvgCommentsPerUser = 0.0;
        double expectedAvgCommentsPerPost = 1.0;

        // Then
        Assert.assertEquals(expectedUsersCount, this.forumStatistics.getUsersCount());
        Assert.assertEquals(expectedPostsCount, this.forumStatistics.getPostsCount());
        Assert.assertEquals(expectedCommentsCount, this.forumStatistics.getCommentsCount());
        Assert.assertEquals(expectedAvgPostsPerUser, this.forumStatistics.getAvgPostsPerUser(), this.allowedDelta);
        Assert.assertEquals(expectedAvgCommentsPerUser, this.forumStatistics.getAvgCommentsPerUser(), this.allowedDelta);
        Assert.assertEquals(expectedAvgCommentsPerPost, this.forumStatistics.getAvgCommentsPerPost(), this.allowedDelta);
    }

    @Test
    public void testCalculateAdvStatisticsHundredUsers() {
        System.out.print("calculateAdvStatistics() 100 users... ");

        // Given
        // this.forumStatistics, this.userNames and this.statistics
        //   Mockito behaviour defined in before(), except for:
        initializeUserNamesList(100);
        when(statistics.userNames()).thenReturn(this.userNames);
        this.forumStatistics.calculateAdvStatistics(this.statistics);

        // When
        int expectedUsersCount = 100;
        int expectedPostsCount = 10_000;
        int expectedCommentsCount = 10_000;
        double expectedAvgPostsPerUser = 100.0;
        double expectedAvgCommentsPerUser = 100.0;
        double expectedAvgCommentsPerPost = 1.0;

        // Then
        Assert.assertEquals(expectedUsersCount, this.forumStatistics.getUsersCount());
        Assert.assertEquals(expectedPostsCount, this.forumStatistics.getPostsCount());
        Assert.assertEquals(expectedCommentsCount, this.forumStatistics.getCommentsCount());
        Assert.assertEquals(expectedAvgPostsPerUser, this.forumStatistics.getAvgPostsPerUser(), this.allowedDelta);
        Assert.assertEquals(expectedAvgCommentsPerUser, this.forumStatistics.getAvgCommentsPerUser(), this.allowedDelta);
        Assert.assertEquals(expectedAvgCommentsPerPost, this.forumStatistics.getAvgCommentsPerPost(), this.allowedDelta);
    }


}
