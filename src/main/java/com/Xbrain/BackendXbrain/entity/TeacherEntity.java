package com.Xbrain.BackendXbrain.entity;

import javax.persistence.*;

@Table(name = "teachers")
@Entity
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacher_id ;

    @Lob
    private String name ;
    private String email ;

}
