package com.Xbrain.BackendXbrain.dto;

import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;
import lombok.Data;

@Data
public class TeacherPostRequestDTO {

    private Long teacher_id ;
    private TeacherPostEntity teacherPostEntity ;

}
