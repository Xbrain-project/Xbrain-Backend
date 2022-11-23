package com.Xbrain.BackendXbrain.bussiness;

import com.Xbrain.BackendXbrain.dto.UpdateStudentReq;
import com.Xbrain.BackendXbrain.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentBusiness {

    @Autowired
    StudentService studentService;

    public void update(UpdateStudentReq req) {
        studentService.updateUser(req,req.getId());

    }
}
