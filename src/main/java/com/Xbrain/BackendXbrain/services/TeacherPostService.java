package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;

import java.util.Optional;

public interface TeacherPostService {
     TeacherPostEntity addTeacherPost(TeacherPostEntity addTeacherPost) ;

    Optional<TeacherPostEntity> updatePost(Long postId , TeacherPostEntity updatePost);

    Optional<TeacherPostEntity> findById(Long postId);

//    List<TeacherPost> searchByIdTeacherPost(Long query);
//    TeacherPost searchByIdTeacherPost(String postID);
//    TeacherPost createTeacherPost(TeacherPost teacherPost);
}
