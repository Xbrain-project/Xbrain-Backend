package com.Xbrain.BackendXbrain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@Table(name = "teacher_posts_xxx")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString

public class TeacherPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id ;
    private String description ;
    private String openCourse;
    private Float reviewScore ;
    private Long price ;
    private String freeTime ;
    private Boolean allowshow ;



    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpenCourse() {
        return openCourse;
    }

    public void setOpenCourse(String openCourse) {
        this.openCourse = openCourse;
    }

    public Float getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(Float reviewScore) {
        this.reviewScore = reviewScore;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(String freeTime) {
        this.freeTime = freeTime;
    }

    public Boolean getAllowshow() {
        return allowshow;
    }

    public void setAllowshow(Boolean allowshow) {
        this.allowshow = allowshow;
    }



}
