package com.Xbrain.BackendXbrain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "teachers_test")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teacher_id ;
    private String name ;
    private String email ;

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
