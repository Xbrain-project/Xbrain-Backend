package com.Xbrain.BackendXbrain.dto;

import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Data

public class SearchDTO {

    private String teacherName ;
    private String description ;

    private Long post_id ;
    private List<String> openCourse ;
    private List<String> studentClass ;
    private List<String> teachType ;
    private List<String> place ;
    private List<String> freeTime ;
    private Timestamp createDate  ;
    private String price ;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public List<String> getOpenCourse() {
        return openCourse;
    }

    public void setOpenCourse(List<String> openCourse) {
        this.openCourse = openCourse;
    }

    public List<String> getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(List<String> studentClass) {
        this.studentClass = studentClass;
    }

    public List<String> getTeachType() {
        return teachType;
    }

    public void setTeachType(List<String> teachType) {
        this.teachType = teachType;
    }

    public List<String> getPlace() {
        return place;
    }

    public void setPlace(List<String> place) {
        this.place = place;
    }

    public List<String> getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(List<String> freeTime) {
        this.freeTime = freeTime;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}