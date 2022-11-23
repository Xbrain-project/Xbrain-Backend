package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.dto.UpdateTeacherReq;
import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.exception.UserException;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<TeacherEntity> teachers ();
    TeacherEntity addTeacher(TeacherEntity addTeacher)  ;
    Optional<TeacherEntity> updatePostOwner(TeacherEntity owner) ;
    List<TeacherEntity> allTeacher();
    TeacherEntity findById(Long teacherId) throws UserException;

    TeacherEntity findByEmail(String email,String password);

    void updateUser(UpdateTeacherReq teacher, Long id);

}
