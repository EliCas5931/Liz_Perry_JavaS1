package com.trilogyed.stwitter.viewmodel;

import com.trilogyed.stwitter.model.Comment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostViewModel {

    private int id;
    private LocalDate postDate;
    private String posterName;
    private String post;

    private List<Comment> commentList;

    public PostViewModel() {

    }

    public PostViewModel(int id, LocalDate postDate, String posterName, String post, List<Comment> commentList) {
        this.id = id;
        this.postDate = postDate;
        this.posterName = posterName;
        this.post = post;
        this.commentList = commentList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostViewModel that = (PostViewModel) o;
        return id == that.id &&
                Objects.equals(postDate, that.postDate) &&
                Objects.equals(posterName, that.posterName) &&
                Objects.equals(post, that.post) &&
                Objects.equals(commentList, that.commentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postDate, posterName, post, commentList);
    }

    @Override
    public String toString() {
        return "PostViewModel{" +
                "id=" + id +
                ", postDate=" + postDate +
                ", posterName='" + posterName + '\'' +
                ", post='" + post + '\'' +
                ", commentList=" + commentList +
                '}';
    }
}
