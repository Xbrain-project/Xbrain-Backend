package com.Xbrain.BackendXbrain.dto;

import com.Xbrain.BackendXbrain.entity.ApplyPostEntity;
import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
// what is DTO layer ? https://stackoverflow.com/questions/40858223/data-transfer-object-class-can-contain-other-objects
public class ApplyPostResponse {

    private List<ApplyPostEntity> applyPostEntity ;
    private TeacherPostEntity teacherPostEntity ;

}
