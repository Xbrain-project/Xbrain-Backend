//package com.Xbrain.BackendXbrain.services;
//
//import com.Xbrain.BackendXbrain.dto.TeacherPostRequest;
//import com.Xbrain.BackendXbrain.entity.TeacherEntity;
//import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;
//import com.Xbrain.BackendXbrain.repository.TeacherPostRepository;
//import com.Xbrain.BackendXbrain.repository.TeacherRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TeacherPostServiceImpl implements TeacherPostService {
//    private TeacherPostRepository teacherPostRepository ;
//    private TeacherRepository teacherRepository ;
//
//    public TeacherPostServiceImpl(TeacherPostRepository teacherPostRepository ,  TeacherRepository teacherRepository) {
//        this.teacherPostRepository = teacherPostRepository;
//        this.teacherRepository  = teacherRepository;
//    }
//
//    @Override
//    public TeacherPostEntity addTeacherPost(TeacherPostRequest request ) {
//        TeacherEntity teacherOwner = request.getTeacherEntity();
//        TeacherPostEntity teacherPost = request.getTeacherPostEntity() ;
//
//        TeacherPostEntity temp_post = teacherPostRepository.save(teacherPost);
//
//        Optional<TeacherEntity> teacherFromDb = teacherRepository.findById(teacherOwner.getTeacher_id()) ;
//        if (teacherFromDb.isPresent()){
//            TeacherEntity temp_teacher = teacherFromDb.get() ;
//            temp_teacher.setTeacherPostEntity(temp_post);
//            teacherRepository.save(temp_teacher);
//            return temp_post ;
//        }
//        else{
//            return null ;
//        }
//
//    }
//
//    @Override
//    public TeacherPostEntity updatePost(TeacherPostRequest request) {
//            TeacherEntity teacherOwner = request.getTeacherEntity();
//            TeacherPostEntity teacherPost = request.getTeacherPostEntity() ;
//
//            Long postId = teacherOwner.getTeacherPostEntity().getPost_id() ;
//
//            Optional<TeacherPostEntity> postFromDB = teacherPostRepository.findById(postId);
//
//            if (postFromDB.isPresent()){
//                TeacherPostEntity fixPost = postFromDB.get() ;
//
//                fixPost.setDescription(teacherPost.getDescription());
//                fixPost.setOpenCourse(teacherPost.getOpenCourse());
//                fixPost.setReviewScore(teacherPost.getReviewScore());
//                fixPost.setPrice(teacherPost.getPrice());
//                fixPost.setFreeTime(teacherPost.getFreeTime());
//
//                teacherPostRepository.save(fixPost);
//                return fixPost;
//
//            }
//            return null ;
//    }
//
//
//    @Override
//    public TeacherPostEntity findById(Long postId) {
//        Optional<TeacherPostEntity> postFromDb = teacherPostRepository.findById(postId);
//        if (postFromDb.isPresent()) {
//            TeacherPostEntity temp_post = postFromDb.get();
//            return temp_post;
//        }else{
//            return null ;
//        }
//    }
//
//    @Override
//    public List<TeacherPostEntity> getAllTeacherPost() {
//        List<TeacherPostEntity> posts = new ArrayList<TeacherPostEntity>();
//
//        teacherPostRepository.findAll().forEach(posts::add);
//
//        return posts;
//    }
//
//
////    @Override
////    public List<TeacherPost> searchByIdTeacherPost(Long query) {
////        List<TeacherPost> searchByIdTP = teacherPostRepository.searchByIdTeacherPost(query);
////        return searchByIdTP;
////    }
//
//
//}
