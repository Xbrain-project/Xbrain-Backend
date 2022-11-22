package com.Xbrain.BackendXbrain.bussiness;

import com.Xbrain.BackendXbrain.dto.UserDTO;
import com.Xbrain.BackendXbrain.entity.StudentEntity;
import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.services.StudentService;
import com.Xbrain.BackendXbrain.services.TeacherService;
import com.Xbrain.BackendXbrain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserBusiness {

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;
    public ResponseEntity login(UserDTO userDTO){


        TeacherEntity teacherByEmail = new TeacherEntity();
        StudentEntity studentByEmail = new StudentEntity();

        if(userDTO.getRole().startsWith("t")) {
            teacherByEmail = teacherService.findByEmail(userDTO.getEmail(), userDTO.getPassword());
            return ResponseEntity.ok(teacherByEmail);
        }
        else {
            studentByEmail = studentService.findByEmail(userDTO.getEmail(), userDTO.getPassword());
            return ResponseEntity.ok(studentByEmail);
        }

    }

    public Object register(UserDTO userDTO,String role){

        Object response = userService.createUser(userDTO,role);


        return ResponseEntity.ok(response);
    }

}
