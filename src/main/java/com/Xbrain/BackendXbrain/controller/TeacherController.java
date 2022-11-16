package com.Xbrain.BackendXbrain.controller;

import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.repository.TeacherRepository;
import com.Xbrain.BackendXbrain.services.TeacherService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Component
public class TeacherController {
    TeacherService teacherService ;
    TeacherRepository teacherRepository ;
    public TeacherController(TeacherService teacherService,TeacherRepository teacherRepository ) {
        this.teacherService = teacherService;
        this.teacherRepository = teacherRepository ;

    }

        @PostMapping(path = "/addTeacher")
    public TeacherEntity addTeacher(@RequestBody TeacherEntity teacherEntity ){
        return teacherService.addTeacher(teacherEntity);
//        return  teacherService.addTeacher(teacherEntity);
    }

//    @GetMapping("/allTeachers")
//    public List<TeacherEntity> teachers() {
//        return teacherService.teachers();
//    }

    @PutMapping("/updatePostToOwner")
    public Optional<TeacherEntity> updatePostOwner(TeacherEntity owner) {
        return teacherService.updatePostOwner(owner) ;
    }

    @GetMapping("/getAllTeachers")
    public  List<TeacherEntity> getAllTeacher() {
        return teacherService.allTeacher() ;
    }

    @GetMapping("/getTeacherById/{teacherId}")
    public  TeacherEntity getTeacherById(@PathVariable("teacherId") Long teacherId){
        return teacherService.findById(teacherId);
    }
}

