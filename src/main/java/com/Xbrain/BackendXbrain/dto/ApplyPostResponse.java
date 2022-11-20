package com.Xbrain.BackendXbrain.dto;

import com.Xbrain.BackendXbrain.entity.ApplyPostEntity;
import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApplyPostResponse {
    private List<ApplyPostEntity> applyPostEntity ;
    private TeacherPostEntity teacherPostEntity ;

}
