package com.Xbrain.BackendXbrain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "teachers")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacher_id ;
    private String name ;
    private String email ;
    private String password;
    private String school;
    private String nickname;
    private String sex;
    private String status;
    private String intro;
    private int phone;
    private String line;

    private String role;


    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private TeacherPostEntity teacherPostEntity ;






}
