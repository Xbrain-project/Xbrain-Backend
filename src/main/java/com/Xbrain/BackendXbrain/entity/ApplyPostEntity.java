package com.Xbrain.BackendXbrain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "applyPosts")
@ToString

public class ApplyPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long apply_id ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacherEntity ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_post_entity_post_id")
    private TeacherPostEntity teacherPostEntity;

    private String status ;

}
