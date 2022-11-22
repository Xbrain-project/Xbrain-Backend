package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.dto.SearchDTO;
import com.Xbrain.BackendXbrain.dto.SearchRequestDTO;
import com.Xbrain.BackendXbrain.dto.TeacherPostRequest;
import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;

import java.util.List;
import java.util.Optional;

public interface TeacherPostService {
     TeacherPostEntity addTeacherPost(TeacherPostEntity teacherPost , Long teacher_id) ;

    TeacherPostEntity updatePost(TeacherPostRequest request);

    TeacherPostEntity findById(Long postId);

    List<TeacherPostEntity> getAllTeacherPost() ;

    List<SearchDTO>searchTeacherPosts(SearchRequestDTO searchRequestDTO ) ;

    List<TeacherPostEntity> searchVerTwo(TeacherPostEntity searchEntity);

    TeacherPostEntity updateAllowShow(Long post_id , TeacherPostEntity request);

    String deleteTeacherPost(Long post_id);

//    List<TeacherPost> searchByIdTeacherPost(Long query);
//    TeacherPost searchByIdTeacherPost(String postID);
//    TeacherPost createTeacherPost(TeacherPost teacherPost);
}
