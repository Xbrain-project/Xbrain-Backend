package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.TeacherEntity;

import java.util.List;

public interface TeacherService {
    List<TeacherEntity> teachers ();
    TeacherEntity addTeacher(TeacherEntity addTeacher)  ;
}
