package com.kodilla.testing.forum;

import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumComment;
import java.util.ArrayList;
import java.util.LinkedList;

public class ForumUser {
    private String name;
    private String realName;
    private ArrayList<ForumPost> posts = new ArrayList<>();
    private LinkedList<ForumComment> comments = new LinkedList<>();

    public ForumUser(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }

    public void addPost(String author, String postBody) {
        posts.add(new ForumPost(postBody, author));
    }

    public void addComment(ForumPost thePost, String author, String commentBody) {
        comments.add(new ForumComment(thePost, commentBody, author));
    }

    public int getPostsQuantity() {
        return posts.size();
    }

    public int getCommentsQuantity() {
        return comments.size();
    }

    public ForumPost getPost(int postNumber) {
        if (postNumber >= 0 && postNumber < posts.size()) {
            return posts.get(postNumber);
        }
        return null;
    }

    public ForumComment getComment(int commentNumber) {
        if (commentNumber >= 0 && commentNumber < comments.size()) {
            return comments.get(commentNumber);
        }
        return null;
    }

    public boolean removePost(ForumPost thePost) {
        boolean result = false;
        if (posts.contains(thePost)) {
            posts.remove(thePost);
            result = true;
        }
        return result;
    }

    public boolean removeComment(ForumComment theComment) {
        boolean result = false;
        if (comments.contains(theComment)) {
            comments.remove(theComment);
            result = true;
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }
}

