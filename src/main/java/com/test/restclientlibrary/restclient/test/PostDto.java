package com.test.restclientlibrary.restclient.test;

public class PostDto {
    int userId;
    int id;
    String title;
    boolean completed;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return String.format("Post: userId -> %d, id -> %d, title -> %s, completed -> %b", userId, id, title, completed);
    }
}
