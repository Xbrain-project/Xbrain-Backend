package com.Xbrain.BackendXbrain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name = "applyPosts")
@ToString

public class ApplyPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apply_id ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacherEntity ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private TeacherPostEntity teacherPostEntity;

    private String status ;


    public ApplyPostEntity() {
    }

    public ApplyPostEntity(Long apply_id, StudentEntity studentEntity, TeacherEntity teacherEntity, TeacherPostEntity teacherPostEntity, String status) {
        this.apply_id = apply_id;
        this.studentEntity = studentEntity;
        this.teacherEntity = teacherEntity;
        this.teacherPostEntity = teacherPostEntity;
        this.status = status;
    }

    public Long getApply_id() {
        return apply_id;
    }

    public void setApply_id(Long apply_id) {
        this.apply_id = apply_id;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public TeacherEntity getTeacherEntity() {
        return teacherEntity;
    }

    public void setTeacherEntity(TeacherEntity teacherEntity) {
        this.teacherEntity = teacherEntity;
    }

    public TeacherPostEntity getTeacherPostEntity() {
        return teacherPostEntity;
    }

    public void setTeacherPostEntity(TeacherPostEntity teacherPostEntity) {
        this.teacherPostEntity = teacherPostEntity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
