package com.Xbrain.BackendXbrain.controller;

import com.Xbrain.BackendXbrain.bussiness.TeacherBusiness;
import com.Xbrain.BackendXbrain.dto.UpdateTeacherReq;
import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.exception.UserException;
import com.Xbrain.BackendXbrain.repository.TeacherRepository;
import com.Xbrain.BackendXbrain.services.TeacherService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Component
@CrossOrigin
public class TeacherController {
    TeacherService teacherService ;
    TeacherRepository teacherRepository ;

    private final TeacherBusiness teacherBusiness;
    public TeacherController(TeacherService teacherService, TeacherRepository teacherRepository, TeacherBusiness teacherBusiness) {
        this.teacherService = teacherService;
        this.teacherRepository = teacherRepository ;

        this.teacherBusiness = teacherBusiness;
    }

    @PostMapping(path = "/addTeacher")
    public TeacherEntity addTeacher(@RequestBody TeacherEntity teacherEntity ){
        return teacherService.addTeacher(teacherEntity);
//        return  teacherService.addTeacher(teacherEntity);
    }

    @GetMapping("/allTeachers")
    public List<TeacherEntity> teachers() {
        return teacherService.teachers();
    }

    @PutMapping("/updatePostToOwner")
    public Optional<TeacherEntity> updatePostOwner(TeacherEntity owner) {
        return teacherService.updatePostOwner(owner) ;
    }

    @PutMapping("/updateTeacher")
    public Optional<TeacherEntity> updateTeacher(@RequestBody UpdateTeacherReq teacher) {
        teacherBusiness.update(teacher);
        return null;
    }

    @GetMapping("/getAllTeachers")
    public  List<TeacherEntity> getAllTeacher() {
        return teacherService.allTeacher() ;
    }

    @GetMapping("/getTeacherById/{teacherId}")
    public  TeacherEntity getTeacherById(@PathVariable("teacherId") Long teacherId) throws UserException {
        return teacherService.findById(teacherId);
    }

    @GetMapping("/testget")
    public List<TeacherEntity> testGet(){
        return  teacherRepository.findAll() ;
    }
}

