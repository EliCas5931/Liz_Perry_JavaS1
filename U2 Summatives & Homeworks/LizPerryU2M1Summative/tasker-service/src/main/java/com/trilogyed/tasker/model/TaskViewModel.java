package com.trilogyed.tasker.model;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Objects;

public class TaskViewModel {

    private int id;
    @NotEmpty(message = "Please input a description!")
    private String description;
    @FutureOrPresent(message = "Please input a valid date!")
    private LocalDate createDate;
    @FutureOrPresent(message = "Please input a valid date!")
    private LocalDate dueDate;
    @NotEmpty(message = "Please input a category!")
    private String category;
    private String advertisement;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskViewModel that = (TaskViewModel) o;
        return id == that.id &&
                Objects.equals(description, that.description) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(dueDate, that.dueDate) &&
                Objects.equals(category, that.category) &&
                Objects.equals(advertisement, that.advertisement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, createDate, dueDate, category, advertisement);
    }

    // Double check if this is needed
//    @Override
//    public String toString() {
//        return "TaskViewModel{" +
//                "id=" + id +
//                ", description='" + description + '\'' +
//                ", createDate=" + createDate +
//                ", dueDate=" + dueDate +
//                ", category='" + category + '\'' +
//                ", advertisement='" + advertisement + '\'' +
//                '}';
//    }
}
