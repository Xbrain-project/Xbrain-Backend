package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.dto.UpdateTeacherReq;
import com.Xbrain.BackendXbrain.dto.UserDTO;
import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.entity.UserEntity;
import com.Xbrain.BackendXbrain.exception.UserException;
import com.Xbrain.BackendXbrain.repository.TeacherRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<TeacherEntity> updatePostOwner(TeacherEntity owner) {
//        Optional<TeacherEntity> teacherFromDb = teacherRepository.findById(owner.getTeacher_id());
//        if(teacherFromDb.isPresent()){
//            TeacherEntity tempTeacher = teacherFromDb.get();
//            tempTeacher.setTeacherPostEntity(owner.getTeacherPostEntity());
//            teacherRepository.save(tempTeacher);
//        }
        return null;
    }

    @Override
    public List<TeacherEntity> allTeacher() {
        List<TeacherEntity> teacherEntities = teacherRepository.findAll();
        List<TeacherEntity> teachers = new ArrayList<>();
        teachers = teacherEntities.stream()
                .map((postEntity) ->
                        TeacherEntity.builder()
                                .teacher_id(postEntity.getTeacher_id())
                                .name(postEntity.getName())
                                .email(postEntity.getEmail())
                                .build()
                ).collect(Collectors.toList());

        return teachers;
    }

    @Override
    public TeacherEntity findById(Long teacherId) throws UserException {

        Optional<TeacherEntity> teacher = teacherRepository.findById(teacherId);
        if(teacher.isPresent()){
            TeacherEntity temp_teacher = teacher.get() ;
            return temp_teacher ;
        }else {
            throw  UserException.userNotFound() ;
        }
    }

    public TeacherEntity findByEmail (String email,String password) {

        TeacherEntity byEmail = teacherRepository.findByEmailAndPassword(email,password);

        return byEmail;
    }

    public void updateUser(UpdateTeacherReq teacher, Long teacherId) {
        Optional<TeacherEntity> byId = this.teacherRepository.findById(teacherId);

        if(byId.isPresent()) {

            byId.get().setName(teacher.getName());
            byId.get().setEmail(teacher.getEmail());
            byId.get().setNickname(teacher.getNickname());
            byId.get().setSchool(teacher.getSchool());
            byId.get().setPhone(teacher.getPhone());
            byId.get().setLine(teacher.getLine());
            byId.get().setSex(teacher.getSex());
            byId.get().setStatus(teacher.getStatus());
            byId.get().setIntro(teacher.getIntro());
        }else
            System.out.println("not");
        TeacherEntity save = teacherRepository.save(byId.get());

    }

    }
