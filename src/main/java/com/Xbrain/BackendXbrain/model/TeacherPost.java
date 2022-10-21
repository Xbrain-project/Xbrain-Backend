package com.Xbrain.BackendXbrain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TeacherPost {
    @Id
    @GeneratedValue
    private Long postId ;
    private String userName ;
    private String description ;
    private String openCourse;
    private Float reviewScore ;
    private Long price ;
    private String freeTime ;

    public TeacherPost() {
    }

    public TeacherPost(String userName, String description, String openCourse, Float reviewScore, Long price, String freeTime) {
        this.userName = userName;
        this.description = description;
        this.openCourse = openCourse;
        this.reviewScore = reviewScore;
        this.price = price;
        this.freeTime = freeTime;
    }

    @Override
    public String toString() {
        return "TeacherPost{" +
                "postId=" + postId +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", openCourse='" + openCourse + '\'' +
                ", reviewScore=" + reviewScore +
                ", price=" + price +
                ", freeTime='" + freeTime + '\'' +
                '}';
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
