package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.dto.TeacherPostRequest;
import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;

import java.util.List;
import java.util.Optional;

public interface TeacherPostService {
     TeacherPostEntity addTeacherPost(TeacherPostRequest request) ;

    TeacherPostEntity updatePost(TeacherPostRequest request);

    TeacherPostEntity findById(Long postId);

    List<TeacherPostEntity> getAllTeacherPost() ;
//    List<TeacherPost> searchByIdTeacherPost(Long query);
//    TeacherPost searchByIdTeacherPost(String postID);
//    TeacherPost createTeacherPost(TeacherPost teacherPost);
}
