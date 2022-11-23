package com.Xbrain.BackendXbrain;

import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;

public class TeacherBuilder {
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

    public TeacherBuilder setName () {
        this.name = name;
        return this;
    }
    public TeacherBuilder setEmail () {
        this.email = email;
        return this;
    }
    public TeacherBuilder setPassword () {
        this.password = password;
        return this;
    }
    public TeacherBuilder setSchool () {
        this.school = school;
        return this;
    }
    public TeacherBuilder setNickname () {
        this.nickname = nickname;
        return this;
    }
    public TeacherBuilder setSex () {
        this.sex = sex;
        return this;
    }
    public TeacherBuilder setStatus() {
        this.status = status;
        return this;
    }
    public TeacherBuilder setIntro() {
        this.intro = intro;
        return this;
    }
    public TeacherBuilder setPhone() {
        this.phone = phone;
        return this;
    }
    public TeacherBuilder setLine() {
        this.line = line;
        return this;
    }
    public TeacherBuilder setRole() {
        this.role = role;
        return this;
    }

    public TeacherEntity build() {
        return new TeacherEntity(   name,  email,  password,  school,  nickname,  sex,  status,  intro,  phone,  line,  role) ;
    }
}
