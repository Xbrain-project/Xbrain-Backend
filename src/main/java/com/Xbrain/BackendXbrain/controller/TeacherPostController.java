package com.Xbrain.BackendXbrain.controller;

import com.Xbrain.BackendXbrain.dto.TeacherPostRequest;
import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;
import com.Xbrain.BackendXbrain.repository.TeacherPostRepository;
import com.Xbrain.BackendXbrain.services.TeacherPostService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
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
    @GetMapping("/getTeacherPost/{postId}")
    public TeacherPostEntity findPostById(@PathVariable("postId") Long postId){
        return teacherPostService.findById(postId);
    }

    @PutMapping(path = "/updatePost")
    public TeacherPostEntity updateTeacherPost(@RequestBody TeacherPostRequest request){
        return  teacherPostService.updatePost(request);
    }

    @PostMapping("/addTeacherPost")
    public TeacherPostEntity newTeacherPost(@RequestBody TeacherPostRequest request ){
//
        return teacherPostService.addTeacherPost(request);

    }
    @GetMapping("/getAllTeacherPost")
    public List<TeacherPostEntity> getAllTeacherPost() {
        return teacherPostService.getAllTeacherPost() ;
    }

    @GetMapping("/search")
    public List<TeacherPostEntity> search(@RequestBody TeacherPostEntity searchEntity ){
    return teacherPostService.searchTeacherPosts(searchEntity) ;
    }

}
