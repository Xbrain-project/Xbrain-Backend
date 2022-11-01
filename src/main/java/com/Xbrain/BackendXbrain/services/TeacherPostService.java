package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.model.TeacherPost;

import java.util.List;
import java.util.function.LongFunction;

public interface TeacherPostService {
    List<TeacherPost> searchTeacherPost(String query);

//    List<TeacherPost> searchByIdTeacherPost(Long query);
//    TeacherPost searchByIdTeacherPost(String postID);
//    TeacherPost createTeacherPost(TeacherPost teacherPost);
}
