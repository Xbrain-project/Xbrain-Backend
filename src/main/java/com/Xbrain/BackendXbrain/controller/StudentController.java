package com.Xbrain.BackendXbrain.controller;


import com.Xbrain.BackendXbrain.bussiness.StudentBusiness;
import com.Xbrain.BackendXbrain.dto.UpdateStudentReq;
import com.Xbrain.BackendXbrain.dto.UpdateTeacherReq;
import com.Xbrain.BackendXbrain.entity.StudentEntity;
import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.exception.UserException;
import com.Xbrain.BackendXbrain.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    StudentBusiness studentBusiness;

    @Autowired
    StudentService studentService;

    @GetMapping("/getStudentById/{studentId}")
    public StudentEntity getStudentById(@PathVariable("studentId") Long studentId) throws UserException {
        return studentService.findById(studentId);
    }

    @PutMapping("/updateStudent")
    public Optional<StudentEntity> updateS(@RequestBody UpdateStudentReq student) {
        studentBusiness.update(student);
        return null;
    }
}
