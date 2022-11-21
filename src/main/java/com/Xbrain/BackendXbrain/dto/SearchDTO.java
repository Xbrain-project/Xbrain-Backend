package com.Xbrain.BackendXbrain.dto;

import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Data

public class SearchDTO {

    private String description ;
    private List<String> openCourse ;
    private List<String> studentClass ;
    private List<String> teachType ;
    private List<String> place ;
    private List<String> freeTime ;
    private Timestamp createDate  ;
    private String price ;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOpenCourse(List<String> openCourse) {
        this.openCourse = openCourse;
    }

    public void setStudentClass(List<String> studentClass) {
        this.studentClass = studentClass;
    }

    public void setTeachType(List<String> teachType) {
        this.teachType = teachType;
    }

    public void setPlace(List<String> place) {
        this.place = place;
    }

    public void setFreeTime(List<String> freeTime) {
        this.freeTime = freeTime;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getOpenCourse() {
        return openCourse;
    }

    public List<String> getStudentClass() {
        return studentClass;
    }

    public List<String> getTeachType() {
        return teachType;
    }

    public List<String> getPlace() {
        return place;
    }

    public List<String> getFreeTime() {
        return freeTime;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public String getPrice() {
        return price;
    }
}
