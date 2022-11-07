package com.Xbrain.BackendXbrain.dto;

import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TeacherPostRequest {
    private TeacherEntity teacherEntity ;
    private TeacherPostEntity teacherPostEntity ;

    public TeacherEntity getTeacherEntity() {
        return teacherEntity;
    }

    public void setTeacherEntity(TeacherEntity teacherEntity) {
        this.teacherEntity = teacherEntity;
    }

    public TeacherPostEntity getTeacherPostEntity() {
        return teacherPostEntity;
    }

    public void setTeacherPostEntity(TeacherPostEntity teacherPostEntity) {
        this.teacherPostEntity = teacherPostEntity;
    }
}
