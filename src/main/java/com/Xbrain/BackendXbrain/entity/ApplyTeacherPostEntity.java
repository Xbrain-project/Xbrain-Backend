package com.Xbrain.BackendXbrain.entity;

import javax.persistence.*;

@Table(name = "teachers")
@Entity
public class ApplyTeacherPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apply_id ;

    @ManyToOne
    @JoinColumn(name = "teacher_entity_teacher_id")
    private TeacherEntity teacherEntity ;

    public TeacherEntity getTeacherEntity() {
        return teacherEntity;
    }

    public void setTeacherEntity(TeacherEntity teacherEntity) {
        this.teacherEntity = teacherEntity;
    }

    @ManyToOne
    @JoinColumn(name = "student_entity_student_id")
    private StudentEntity studentEntity;

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

//    @OneToMany
    @ManyToOne
    @JoinColumn(name = "teacher_post_entity_post_id")
    private TeacherPostEntity teacherPostEntity;

    public TeacherPostEntity getTeacherPostEntity() {
        return teacherPostEntity;
    }

    public void setTeacherPostEntity(TeacherPostEntity teacherPostEntity) {
        this.teacherPostEntity = teacherPostEntity;
    }

}
