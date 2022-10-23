package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.model.TeacherPost;
import com.Xbrain.BackendXbrain.repository.TeacherPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherPostServiceImpl implements TeacherPostService {
    private TeacherPostRepository teacherPostRepository ;

    public TeacherPostServiceImpl(TeacherPostRepository teacherPostRepository) {
        this.teacherPostRepository = teacherPostRepository;
    }

    @Override
    public List<TeacherPost> searchTeacherPost(String query){
        List<TeacherPost> searchTP = teacherPostRepository.searchTeacherPost(query);
        return searchTP;
    }

//    @Override
//    public List<TeacherPost> searchByIdTeacherPost(Long query) {
//        List<TeacherPost> searchByIdTP = teacherPostRepository.searchByIdTeacherPost(query);
//        return searchByIdTP;
//    }


}
