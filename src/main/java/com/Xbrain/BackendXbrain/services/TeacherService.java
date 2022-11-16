package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.TeacherEntity;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
//    List<TeacherEntity> teachers ();
    TeacherEntity addTeacher(TeacherEntity addTeacher)  ;
    Optional<TeacherEntity> updatePostOwner(TeacherEntity owner) ;
    List<TeacherEntity> allTeacher();
    TeacherEntity findById(Long teacherId);

}
