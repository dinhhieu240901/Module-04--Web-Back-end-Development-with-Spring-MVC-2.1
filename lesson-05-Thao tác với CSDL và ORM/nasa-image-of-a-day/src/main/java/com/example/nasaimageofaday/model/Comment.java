package com.example.nasaimageofaday.model;

import javax.persistence.*;

@Entity
@Table

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "author")
    private String authorName;

    @Column(name = "comment")
    private String commentText;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "likes")
    private Integer likes;

    public Comment() {
    }

    public Comment(int id, String authorName, String commentText, Integer rating, Integer likes) {
        this.id = id;
        this.authorName = authorName;
        this.commentText = commentText;
        this.rating = rating;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}
