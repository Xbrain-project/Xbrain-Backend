package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.model.TeacherPost;

import java.util.List;

public interface TeacherPostService {
    List<TeacherPost> searchTeacherPost(String query);

    TeacherPost createTeacherPost(TeacherPost teacherPost);
}
