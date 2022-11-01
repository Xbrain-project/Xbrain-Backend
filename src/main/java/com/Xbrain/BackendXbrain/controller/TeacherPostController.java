package com.Xbrain.BackendXbrain.controller;

import com.Xbrain.BackendXbrain.model.TeacherPost;
import com.Xbrain.BackendXbrain.repository.TeacherPostRepository;
import com.Xbrain.BackendXbrain.services.TeacherPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherPostController {

    private TeacherPostService teacherPostService ;
    @Autowired
    private TeacherPostRepository teacherPostRepository ;

    @Autowired
    public TeacherPostController(TeacherPostService teacherPostService, TeacherPostRepository teacherPostRepository) {
        this.teacherPostService = teacherPostService;
        this.teacherPostRepository = teacherPostRepository;
    }

    @PostMapping("/tpost")
    TeacherPost newTeacherPost(@RequestBody TeacherPost newTeacherPost){
        return teacherPostRepository.save(newTeacherPost);
    }

    @GetMapping("/gettposts")
    List<TeacherPost> getAllTeacherPost(){
        return teacherPostRepository.findAll();
    }

    @GetMapping("/search")
    public ResponseEntity<List<TeacherPost>> searchTeacherPost(@RequestParam("query") String query){
        return ResponseEntity.ok(teacherPostService.searchTeacherPost(query));
    }

//    @GetMapping("/sbpid")
//    List<TeacherPost> searchByIdTeacherPost(@RequestParam("query") Long query){
//        return teacherPostRepository.findById(query);
//    }

//    @PutMapping
//    public List<TeacherPost> updatePost(){
//        return ;
//    }

//    @PostMapping("/alltpost")
//    public TeacherPost createTeacherPost(@RequestBody TeacherPost teacherPost){
//        return  teacherPostService.createTeacherPost(teacherPost);
//    }

}
