package com.Xbrain.BackendXbrain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@Entity
@Data
@Table(name = "applyPosts")
@ToString
@NoArgsConstructor
@Builder

public class ApplyPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apply_id ;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private StudentEntity studentEntity ;

    @ManyToOne(cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private TeacherPostEntity teacherPostEntity;

    private String status ;

    private Timestamp applyDate  ;

}
