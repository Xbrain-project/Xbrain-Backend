package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.dto.SearchDTO;
import com.Xbrain.BackendXbrain.dto.SearchRequestDTO;
import com.Xbrain.BackendXbrain.dto.TeacherPostRequest;
import com.Xbrain.BackendXbrain.entity.ApplyPostEntity;
import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;
import com.Xbrain.BackendXbrain.repository.ApplyPostRepostity;
import com.Xbrain.BackendXbrain.repository.TeacherPostRepository;
import com.Xbrain.BackendXbrain.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TeacherPostServiceImpl implements TeacherPostService {
    private TeacherPostRepository teacherPostRepository ;
    private TeacherRepository teacherRepository ;

    private ApplyPostRepostity applyPostRepostity ;


    public TeacherPostServiceImpl(TeacherPostRepository teacherPostRepository, TeacherRepository teacherRepository, ApplyPostRepostity applyPostRepostity) {
        this.teacherPostRepository = teacherPostRepository;
        this.teacherRepository = teacherRepository;
        this.applyPostRepostity = applyPostRepostity;
    }

    public SearchDTO ConvertSearchToDTO( TeacherPostEntity searchedPost ){

        SearchDTO searchDto = new SearchDTO() ;

        System.out.println("get post id "+searchedPost.getPost_id());

        TeacherEntity teacher = teacherRepository.findbyPostId(searchedPost.getPost_id())  ;
        System.out.println("teacher"+teacher);

        searchDto.setTeacherName(  teacher.getName() );
        searchDto.setDescription(searchedPost.getDescription());
        searchDto.setOpenCourse(searchedPost.getOpenCourse());
        searchDto.setStudentClass(searchedPost.getStudentClass());
        searchDto.setTeachType(searchedPost.getTeachType());
        searchDto.setPlace(searchedPost.getPlace());
        searchDto.setFreeTime(searchedPost.getFreeTime());
        searchDto.setCreateDate(searchedPost.getCreateDate());
        searchDto.setPrice(searchedPost.getPrice());

        return searchDto ;
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
        System.out.println("list size is :"+list.size());

        if (list.size() == 0 || list.equals(null) ) {
            String result = "." ;
            System.out.println("result is :"+result);

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
    public TeacherPostEntity addTeacherPost(TeacherPostEntity teacherPostInput , Long teacher_id) {

        Calendar calendar = Calendar.getInstance() ;

        Optional<TeacherEntity> teacher = teacherRepository.findById(teacher_id) ;
        TeacherEntity teacherOwner = teacher.get() ;
        System.out.println("teacherOwner"+teacherOwner);
        TeacherPostEntity teacherPost = teacherPostInput ;

        TeacherPostEntity temp_post  = teacherPost ;
        temp_post.setCreateDate(new Timestamp(calendar.getTimeInMillis()));

        temp_post.setOpenCoursesX(listToString(teacherPost.getOpenCourse() ));
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
    public List<SearchDTO> searchTeacherPosts(SearchRequestDTO searchRequestDTO ) {

        String courses = listToQuery(searchRequestDTO.getOpenCourse() );
        String places = listToQuery(searchRequestDTO.getPlace() );
        String classes = listToQuery(searchRequestDTO.getStudentClass() );
        String types = listToQuery(searchRequestDTO.getTeachType() );

        List<TeacherPostEntity> posts = teacherPostRepository.searchTeacherPosts( courses ,  places ,  classes ,  types );
        List<TeacherEntity> teahcers = new ArrayList<>();

        List<SearchDTO> res = new ArrayList<>() ;
        int i = 0 ;
        while ( i < posts.size() ) {
            SearchDTO sDto = new SearchDTO() ;
            System.out.println("posts.id is : "+posts.get(i));
            System.out.println("posts.id get post id is : "+posts.get(i).getPost_id());

            sDto = ConvertSearchToDTO( posts.get(i) ) ;
            System.out.println("sDTO is : "+sDto);
            res.add(sDto);
            i = i + 1 ;
        }

        return res ;
//    return posts ;
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

    @Override
    public TeacherPostEntity updateAllowShow(Long post_id , TeacherPostEntity request) {
        Optional<TeacherPostEntity> postFromDb = teacherPostRepository.findById(post_id);
        TeacherPostEntity temp_post = postFromDb.get();
        temp_post.setAllowshow(request.getAllowshow());

        return teacherPostRepository.save(temp_post);
    }

    @Override
    public String deleteTeacherPost(Long post_id) {
        TeacherEntity teacher = teacherRepository.deleteTeacherPost(post_id) ;
        teacher.setTeacherPostEntity(null);
        List<ApplyPostEntity> applyPosts = applyPostRepostity.deleteTeacherPost(post_id);

        for (int i = 0 ; i < applyPosts.size() ; i = i+1) {
            ApplyPostEntity applyPost = applyPosts.get(i);
            applyPost.setStudentEntity(null);
            applyPost.setTeacherPostEntity(null);
            applyPostRepostity.delete(applyPost);
        }

        teacherPostRepository.deleteById(post_id) ;
        return "post : "+post_id + " deleted";
    }


//    @Override
//    public List<TeacherPost> searchByIdTeacherPost(Long query) {
//        List<TeacherPost> searchByIdTP = teacherPostRepository.searchByIdTeacherPost(query);
//        return searchByIdTP;
//    }


}
