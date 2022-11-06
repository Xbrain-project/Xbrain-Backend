package com.Xbrain.BackendXbrain.controller;

import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.repository.TeacherRepository;
import com.Xbrain.BackendXbrain.services.TeacherService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
public class TeacherController {
    TeacherService teacherService ;
    TeacherRepository teacherRepository ;
    public TeacherController(TeacherService teacherService,TeacherRepository teacherRepository ) {
        this.teacherService = teacherService;
        this.teacherRepository = teacherRepository ;

    }

    @PostMapping("/addTeacher")
    public TeacherEntity addTeacher(@RequestBody TeacherEntity teacherEntity){
        return teacherService.addTeacher(teacherEntity);
//        return  teacherService.addTeacher(teacherEntity);
    }

    @GetMapping("/allTeachers")
    public List<TeacherEntity> teachers() {
        return teacherService.teachers();
    }
}
