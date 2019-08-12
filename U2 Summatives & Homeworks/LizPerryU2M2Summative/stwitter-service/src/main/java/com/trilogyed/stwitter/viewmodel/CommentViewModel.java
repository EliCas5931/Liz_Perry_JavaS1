package com.trilogyed.stwitter.viewmodel;

import java.time.LocalDate;
import java.util.Objects;

public class CommentViewModel {

    private LocalDate createDate;
    private String commenterName;
    private String comment;

    public CommentViewModel() {

    }

    public CommentViewModel(LocalDate createDate, String commenterName, String comment) {
        this.createDate = createDate;
        this.commenterName = commenterName;
        this.comment = comment;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentViewModel that = (CommentViewModel) o;
        return Objects.equals(createDate, that.createDate) &&
                Objects.equals(commenterName, that.commenterName) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createDate, commenterName, comment);
    }

    @Override
    public String toString() {
        return "CommentViewModel{" +
                "createDate=" + createDate +
                ", commenterName='" + commenterName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
