package com.trilogyed.post.model;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Objects;

public class Post {

    private int postID;
    @NotEmpty(message = "Please post a date!")
    private LocalDate postDate;
    @NotEmpty(message = "Please input a poster name!")
    private String posterName;
    @NotEmpty(message = "Please leave a post!")
    private String post;

    public Post() {
    }

    public Post(int postID, LocalDate postDate, String posterName, String post) {
        this.postID = postID;
        this.postDate = postDate;
        this.posterName = posterName;
        this.post = post;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post1 = (Post) o;
        return postID == post1.postID &&
                postDate.equals(post1.postDate) &&
                posterName.equals(post1.posterName) &&
                Objects.equals(post, post1.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postID, postDate, posterName, post);
    }

    @Override
    public String toString() {
        return "Post{" +
                "postID=" + postID +
                ", postDate=" + postDate +
                ", posterName='" + posterName + '\'' +
                ", post='" + post + '\'' +
                '}';
    }
}
