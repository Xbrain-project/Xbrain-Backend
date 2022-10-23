package com.Xbrain.BackendXbrain.entity;

import javax.persistence.*;

@Table(name = "teacher_posts_xxx")
@Entity
public class TeacherPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id ;

    @ManyToOne
    @JoinColumn(name = "teacher_entity_teacher_id")
    private TeacherEntity teacherEntity;
    @Lob
    private String description ;
    private String openCourse;
    private Float reviewScore ;
    private Long price ;
    private String freeTime ;
    private Boolean allowshow ;

    public TeacherEntity getTeacherEntity() {
        return teacherEntity;
    }

    public void setTeacherEntity(TeacherEntity teacherEntity) {
        this.teacherEntity = teacherEntity;
    }
}
