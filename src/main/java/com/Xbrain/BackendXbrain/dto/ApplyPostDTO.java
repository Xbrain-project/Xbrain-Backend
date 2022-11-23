package com.Xbrain.BackendXbrain.dto;

import lombok.Data;

import java.util.List;

@Data
public class ApplyPostDTO {
    private Long post_id ;
    private List<String> course ;
    private List<String> teachType ;
    private List<String> place;

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public List<String> getCourse() {
        return course;
    }

    public void setCourse(List<String> course) {
        this.course = course;
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
}
