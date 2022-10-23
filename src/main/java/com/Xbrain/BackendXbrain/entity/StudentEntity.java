package com.Xbrain.BackendXbrain.entity;

import javax.persistence.*;

@Table(name = "students")
@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id ;

    @Lob
    private String name ;
    private String email ;
}
