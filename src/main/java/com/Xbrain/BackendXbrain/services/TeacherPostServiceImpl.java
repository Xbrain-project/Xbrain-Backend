package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;
import com.Xbrain.BackendXbrain.repository.TeacherPostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherPostServiceImpl implements TeacherPostService {
    private TeacherPostRepository teacherPostRepository ;

    public TeacherPostServiceImpl(TeacherPostRepository teacherPostRepository) {
        this.teacherPostRepository = teacherPostRepository;
    }

    @Override
    public TeacherPostEntity addTeacherPost(TeacherPostEntity addTeacherPost) {
        return teacherPostRepository.save(addTeacherPost);
    }

    @Override
    public Optional<TeacherPostEntity> updatePost(Long postId, TeacherPostEntity updatePost) {
        Optional<TeacherPostEntity> postFromDB = teacherPostRepository.findById(postId);
        if (postFromDB.isPresent()){
            TeacherPostEntity fixPost = postFromDB.get() ;

            fixPost.setDescription(updatePost.getDescription());
            fixPost.setOpenCourse(updatePost.getOpenCourse());
            fixPost.setReviewScore(updatePost.getReviewScore());
            fixPost.setPrice(updatePost.getPrice());
            fixPost.setFreeTime(updatePost.getFreeTime());
            fixPost.setAllowshow(updatePost.getAllowshow());
            fixPost.setTeacherEntity(fixPost.getTeacherEntity());

            teacherPostRepository.save(fixPost);

        }
        return postFromDB;
    }

    @Override
    public Optional<TeacherPostEntity> findById(Long postId) {
        return teacherPostRepository.findById(postId);
    }


//    @Override
//    public List<TeacherPost> searchByIdTeacherPost(Long query) {
//        List<TeacherPost> searchByIdTP = teacherPostRepository.searchByIdTeacherPost(query);
//        return searchByIdTP;
//    }


}
