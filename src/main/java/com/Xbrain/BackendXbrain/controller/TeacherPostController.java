package com.Xbrain.BackendXbrain.controller;

import com.Xbrain.BackendXbrain.dto.*;
import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;
import com.Xbrain.BackendXbrain.repository.TeacherPostRepository;
import com.Xbrain.BackendXbrain.services.TeacherPostService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")

public class TeacherPostController {

    private TeacherPostService teacherPostService ;
    @Autowired
    private TeacherPostRepository teacherPostRepository ;

    @Autowired
    public TeacherPostController(
            TeacherPostService teacherPostService ,
            TeacherPostRepository teacherPostRepository
    )
    {
        this.teacherPostService = teacherPostService;
        this.teacherPostRepository = teacherPostRepository;
    }
    @PostMapping("/test_search")
    public String testsearch( SearchRequestDTO searchRequestDTO){

        System.out.println("hello world "+searchRequestDTO);

        return "test test test";
    }
    @GetMapping("/getTeacherPost/{postId}")
    public TeacherPostEntity findPostById(@PathVariable("postId") Long postId){
        return teacherPostService.findById(postId);
    }

    @PutMapping(path = "/updatePost")
    public TeacherPostEntity updateTeacherPost(@RequestBody TeacherPostRequest request){
        return  teacherPostService.updatePost(request);
    }

    @PostMapping("/addTeacherPost/{teacher_id}")
    public TeacherPostEntity newTeacherPost(@RequestBody TeacherPostEntity teacherPost , @PathVariable("teacher_id") Long teacher_id ){
        System.out.println(teacherPost);
//        return null ;
        //
        return teacherPostService.addTeacherPost( teacherPost ,  teacher_id);

    }

//    @GetMapping("/addTeacherPost/{s_id}")
//    public TeacherPostEntity newTeacherPost(@PathVariable("s_id") Long teacher_id ){
//        System.out.println(teacherPost);
////        return null ;
//        //
//        return teacherPostService.addTeacherPost( teacherPost ,  teacher_id);
//
//    }
    @GetMapping("/getAllTeacherPost")
    public List<TeacherPostEntity> getAllTeacherPost() {
        return teacherPostService.getAllTeacherPost() ;
    }

    @PostMapping("/search")
    public List<SearchDTO> search(@RequestBody SearchRequestDTO searchRequestDTO ){
        System.out.println("hehe!!"+searchRequestDTO);
//        return null ;
        return teacherPostService.searchTeacherPosts(searchRequestDTO);
    }

    @GetMapping("/searchVer2")
    public List<TeacherPostEntity> searchVerTwo(@RequestBody TeacherPostEntity searchEntity){
        return teacherPostService.searchVerTwo(searchEntity) ;
    }

    @PutMapping("/updateAllowShow/{post_id}")
    public TeacherPostEntity updateAllowShow(@PathVariable ("post_id") Long post_id , @RequestBody TeacherPostEntity request){
        return teacherPostService.updateAllowShow(post_id ,  request) ;
    }

    @DeleteMapping("/deleteTeahcerPost/{post_id}")
    public String deleteTeacherPost(@PathVariable ("post_id") Long post_id){
        return teacherPostService.deleteTeacherPost(post_id) ;
    }





}