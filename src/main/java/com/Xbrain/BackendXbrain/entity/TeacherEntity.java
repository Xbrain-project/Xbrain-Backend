package com.Xbrain.BackendXbrain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "teachers")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

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

    public TeacherEntity(String name, String email, String password, String school, String nickname, String sex, String status, String intro, int phone, String line, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.school = school;
        this.nickname = nickname;
        this.sex = sex;
        this.status = status;
        this.intro = intro;
        this.phone = phone;
        this.line = line;
        this.role = role;
    }


    public static class TeacherBuilder {
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

        public TeacherBuilder() {
        }

        public TeacherBuilder setName (String name) {
            this.name = name;
            return this;
        }
        public TeacherBuilder setEmail (String email) {
            this.email = email;
            return this;
        }
        public TeacherBuilder setPassword (String password) {
            this.password = password;
            return this;
        }
        public TeacherBuilder setSchool (String school) {
            this.school = school;
            return this;
        }
        public TeacherBuilder setNickname (String nickname) {
            this.nickname = nickname;
            return this;
        }
        public TeacherBuilder setSex (String sex) {
            this.sex = sex;
            return this;
        }
        public TeacherBuilder setStatus(String status) {
            this.status = status;
            return this;
        }
        public TeacherBuilder setIntro(String intro) {
            this.intro = intro;
            return this;
        }
        public TeacherBuilder setPhone(int phone) {
            this.phone = phone;
            return this;
        }
        public TeacherBuilder setLine(String line) {
            this.line = line;
            return this;
        }
        public TeacherBuilder setRole(String role) {
            this.role = role;
            return this;
        }

        public TeacherEntity build() {
            return new TeacherEntity(   name,  email,  password,  school,  nickname,  sex,  status,  intro,  phone,  line,  role) ;
        }
    }


}
