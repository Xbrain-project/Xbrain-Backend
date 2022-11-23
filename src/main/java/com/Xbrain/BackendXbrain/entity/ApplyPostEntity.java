package com.Xbrain.BackendXbrain.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private StudentEntity studentEntity ;

    @ManyToOne(cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private TeacherPostEntity teacherPostEntity;

    private String course ;

    private String teachType ;

    private String price ;

    private String place ;

    private String status ;

    private Timestamp applyDate  ;

}
