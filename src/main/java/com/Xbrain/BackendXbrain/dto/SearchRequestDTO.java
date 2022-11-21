package com.Xbrain.BackendXbrain.dto;

import lombok.Data;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import java.util.List;

@Data
public class SearchRequestDTO {
    private List<String> openCourse ;
    private List<String> studentClass  ;
    private List<String> teachType ;
    private List<String> place;

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
}
