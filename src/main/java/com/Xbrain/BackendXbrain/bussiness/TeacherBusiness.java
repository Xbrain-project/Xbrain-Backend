package com.Xbrain.BackendXbrain.bussiness;


import com.Xbrain.BackendXbrain.dto.UpdateTeacherReq;
import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherBusiness {

    @Autowired
    TeacherService teacherService;

    public void update(UpdateTeacherReq req) {
        teacherService.updateUser(req,req.getId());

    }
}
