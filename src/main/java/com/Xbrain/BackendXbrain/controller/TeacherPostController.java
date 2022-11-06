package com.Xbrain.BackendXbrain.controller;

import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;
import com.Xbrain.BackendXbrain.repository.TeacherPostRepository;
import com.Xbrain.BackendXbrain.services.TeacherPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(path = "/getTeacherPost/{postId}")
    public Optional<TeacherPostEntity> findPostById(@PathVariable("postId") Long postId){
        return teacherPostService.findById(postId);
    }

    @PutMapping(path = "/updatePost/{postId}")
    public Optional<TeacherPostEntity> updateTeacherPost(
                @PathVariable("postId") Long postId ,
                @RequestBody TeacherPostEntity updateTeacherPost
            ){
        return  teacherPostService.updatePost(postId ,updateTeacherPost );
    }

    @PostMapping("/addTeacherPost")
    public TeacherPostEntity newTeacherPost(@RequestBody TeacherPostEntity addTeacherPost ){
        return teacherPostService.addTeacherPost(addTeacherPost) ;
    }


}
