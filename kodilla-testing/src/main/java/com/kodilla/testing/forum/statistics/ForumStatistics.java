package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        this.usersCount = statistics.userNames().size();
        this.postsCount = statistics.postsCount();
        this.commentsCount = statistics.commentsCount();

        if (this.usersCount > 0) {
            this.avgPostsPerUser = (double)this.postsCount / (double)this.usersCount;
        } else {
            this.avgPostsPerUser = 0.0;
        }

        if (this.usersCount > 0) {
            this.avgCommentsPerUser = (double)this.commentsCount / (double)this.usersCount;
        } else {
            this.avgCommentsPerUser = 0.0;
        }

        if (this.postsCount > 0) {
            this.avgCommentsPerPost = (double)this.commentsCount / (double)this.postsCount;
        } else {
            this.avgCommentsPerPost = 0.0;
        }
    }

    public void showStatistics() {
        System.out.println("Forum statistics:");
        System.out.println("Users count: " + this.usersCount);
        System.out.println("Posts count: " + this.postsCount);
        System.out.println("Comments count: " + this.commentsCount);
        System.out.println("Average posts per user: " + this.avgPostsPerUser);
        System.out.println("Average comments per user: " + this.avgCommentsPerUser);
        System.out.println("Average comments per posts: " + this.avgCommentsPerPost);
    }

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }
}
