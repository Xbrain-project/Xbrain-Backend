package com.Xbrain.BackendXbrain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.persistence.*;
import java.sql.Timestamp;

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

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private TeacherPostEntity teacherPostEntity ;



}
