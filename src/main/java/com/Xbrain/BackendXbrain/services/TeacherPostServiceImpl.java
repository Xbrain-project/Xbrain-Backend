package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.dto.TeacherPostRequest;
import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;
import com.Xbrain.BackendXbrain.repository.TeacherPostRepository;
import com.Xbrain.BackendXbrain.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TeacherPostServiceImpl implements TeacherPostService {
    private TeacherPostRepository teacherPostRepository ;
    private TeacherRepository teacherRepository ;

    public TeacherPostServiceImpl(TeacherPostRepository teacherPostRepository ,  TeacherRepository teacherRepository) {
        this.teacherPostRepository = teacherPostRepository;
        this.teacherRepository  = teacherRepository;
    }

    public String listToString(List<String> list) {
        List<String> stringList = list ;
        String result = stringList.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(",")) ;
        return  result;
    }

    public String listToQuery(List<String> list) {
//        "." in REGEXP sql mean -> Any single character
        if (list.size() == 0 || list.equals(null) ) {
            String result = "." ;
            return result ;
        } else {
        List<String> stringList = list ;
        String result = stringList.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining("|")) ;
        System.out.println(result);
        return  result;

        }
    }



    @Override
    public TeacherPostEntity addTeacherPost(TeacherPostRequest request ) {

        Calendar calendar = Calendar.getInstance() ;

        TeacherEntity teacherOwner = request.getTeacherEntity();
        TeacherPostEntity teacherPost = request.getTeacherPostEntity() ;

        TeacherPostEntity temp_post  = teacherPost ;
        temp_post.setCreateDate(new Timestamp(calendar.getTimeInMillis()));

        temp_post.setOpenCoursesX(listToString(teacherPost.getOpenCourse()));
        temp_post.setStudentClassesX(listToString(teacherPost.getStudentClass()));
        temp_post.setTeachTypesX(listToString(teacherPost.getTeachType()));
        temp_post.setPlacesX(listToString(teacherPost.getPlace()));
        temp_post.setFreeTimesX(listToString(teacherPost.getFreeTime()));

        teacherPostRepository.save(temp_post) ;

        Optional<TeacherEntity> teacherFromDb = teacherRepository.findById(teacherOwner.getTeacher_id()) ;
        if (teacherFromDb.isPresent()){
            TeacherEntity temp_teacher = teacherFromDb.get() ;
            temp_teacher.setTeacherPostEntity(temp_post);

            teacherRepository.save(temp_teacher);
            return temp_post ;
        }
        else{
            return null ;
        }

    }

    @Override
    public TeacherPostEntity updatePost(TeacherPostRequest request) {
            TeacherEntity teacherOwner = request.getTeacherEntity();
            TeacherPostEntity teacherPost = request.getTeacherPostEntity() ;

            Long postId = teacherOwner.getTeacherPostEntity().getPost_id() ;

            Optional<TeacherPostEntity> postFromDB = teacherPostRepository.findById(postId);

            if (postFromDB.isPresent()){
                TeacherPostEntity fixPost = postFromDB.get() ;

                fixPost.setDescription(teacherPost.getDescription());
                fixPost.setOpenCourse(teacherPost.getOpenCourse());
                fixPost.setStudentClass(teacherPost.getStudentClass());
                fixPost.setTeachType(teacherPost.getTeachType());
                fixPost.setPlace(teacherPost.getPlace());
                fixPost.setFreeTime(teacherPost.getFreeTime());
                fixPost.setPrice(teacherPost.getPrice());

                teacherPostRepository.save(fixPost);
                return fixPost;

            }
            return null ;
    }


    @Override
    public TeacherPostEntity findById(Long postId) {
        Optional<TeacherPostEntity> postFromDb = teacherPostRepository.findById(postId);
        if (postFromDb.isPresent()) {
            TeacherPostEntity temp_post = postFromDb.get();
            return temp_post;
        }else{
            return null ;
        }
    }

    @Override
    public List<TeacherPostEntity> getAllTeacherPost() {
        List<TeacherPostEntity> teacherPostEntities = teacherPostRepository.findAll();
        List<TeacherPostEntity> teacherPosts = new ArrayList<>();
        teacherPosts = teacherPostEntities.stream()
                .map((postEntity) ->
                        TeacherPostEntity.builder()
                                .post_id(postEntity.getPost_id())
                                .description(postEntity.getDescription())
                                .studentClass(postEntity.getStudentClass())
                                .teachType(postEntity.getTeachType())
                                .place(postEntity.getPlace())
                                .price(postEntity.getPrice())
                                .freeTime(postEntity.getFreeTime())
                                .openCourse(postEntity.getOpenCourse())
                                .allowshow(postEntity.getAllowshow())
                                .createDate(postEntity.getCreateDate())
                                .build()
                ).collect(Collectors.toList());

        return teacherPosts;
    }

    @Override
    public List<TeacherPostEntity> searchTeacherPosts(TeacherPostEntity searchEntity) {

        String courses = listToQuery(searchEntity.getOpenCourse() );
        String places = listToQuery(searchEntity.getPlace() );
        String classes = listToQuery(searchEntity.getStudentClass() );
        String types = listToQuery(searchEntity.getTeachType() );

        return teacherPostRepository.searchTeacherPosts( courses ,  places ,  classes ,  types );
    }

    @Override
    public List<TeacherPostEntity> searchVerTwo(TeacherPostEntity searchEntity) {

        String courses = listToString(searchEntity.getOpenCourse() );
        String places = listToString(searchEntity.getPlace() );
        String types = listToString(searchEntity.getTeachType());
        String classes = listToString(searchEntity.getStudentClass()) ;

        List<TeacherPostEntity> coursesFromDb = teacherPostRepository.searchFromCourses(courses);


//            List<TeacherPostEntity> placesFromDb = teacherPostRepository.searchFromPlaces(places);
//            List<TeacherPostEntity> typesFromDb = teacherPostRepository.searchFromTypes(types);
//            List<TeacherPostEntity> classesFromDb = teacherPostRepository.searchFromClasses(classes);

//        if(courses != null || courses.isEmpty() == false || courses.trim().isEmpty() == false){
//            List<TeacherPostEntity> coursesFromDb = teacherPostRepository.searchFromCourses(courses);
//        }
//        if(places != null || places.isEmpty() == false || places.trim().isEmpty() == false){
//            List<TeacherPostEntity> placesFromDb = teacherPostRepository.searchFromPlaces(places);
//        }
//        if(types != null || types.isEmpty() == false || types.trim().isEmpty() == false){
//            List<TeacherPostEntity> typesFromDb = teacherPostRepository.searchFromTypes(types);
//        }
//        if(classes != null || classes.isEmpty() == false || classes.trim().isEmpty() == false){
//            List<TeacherPostEntity> classesFromDb = teacherPostRepository.searchFromClasses(classes);
//        }


        return coursesFromDb;
    }


//    @Override
//    public List<TeacherPost> searchByIdTeacherPost(Long query) {
//        List<TeacherPost> searchByIdTP = teacherPostRepository.searchByIdTeacherPost(query);
//        return searchByIdTP;
//    }


}
