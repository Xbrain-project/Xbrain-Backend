package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService{
    TeacherRepository teacherRepository ;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<TeacherEntity> teachers() {
        List<TeacherEntity> teacherEntities = teacherRepository.findAll();

        List<TeacherEntity> teachers  = new ArrayList<>();

        teachers = teacherEntities.stream()
                .map((teacherEntity) ->
                        TeacherEntity.builder()
                                .email(teacherEntity.getEmail())
                                .name(teacherEntity.getName())
                                .teacher_id(teacherEntity.getTeacher_id())
                                .build()
                ).collect(Collectors.toList());
        return teachers;

    }

    @Override
    public TeacherEntity addTeacher(TeacherEntity addTeacher ) {
        return  teacherRepository.save(addTeacher) ;
    }


}
