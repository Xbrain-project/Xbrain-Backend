package com.Xbrain.BackendXbrain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "teachers_test")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacher_id ;
    private String name ;
    private String email ;


    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private TeacherPostEntity teacherPostEntity ;

    public TeacherPostEntity getTeacherPostEntity() {
        return teacherPostEntity;
    }

    public void setTeacherPostEntity(TeacherPostEntity teacherPostEntity) {
        this.teacherPostEntity = teacherPostEntity;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
