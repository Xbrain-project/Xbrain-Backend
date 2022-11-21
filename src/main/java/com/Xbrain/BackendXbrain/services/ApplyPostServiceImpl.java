package com.Xbrain.BackendXbrain.services;

//import com.Xbrain.BackendXbrain.dto.ApplyPostRequest;
import com.Xbrain.BackendXbrain.dto.ApplyPostResponse;
import com.Xbrain.BackendXbrain.entity.ApplyPostEntity;
import com.Xbrain.BackendXbrain.entity.StudentEntity;
import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;
import com.Xbrain.BackendXbrain.repository.ApplyPostRepostity;
import com.Xbrain.BackendXbrain.repository.StudentRepository;
import com.Xbrain.BackendXbrain.repository.TeacherPostRepository;
import com.Xbrain.BackendXbrain.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplyPostServiceImpl implements ApplyPostService{
    @Autowired
    ApplyPostRepostity applyPostRepostity ;
    @Autowired
    TeacherRepository teacherRepository ;
    @Autowired
    TeacherPostRepository teacherPostRepository ;
    @Autowired
    StudentRepository studentRepository ;

    public ApplyPostServiceImpl(ApplyPostRepostity applyPostRepostity, TeacherRepository teacherRepository, TeacherPostRepository teacherPostRepository, StudentRepository studentRepository) {
        this.applyPostRepostity = applyPostRepostity;
        this.teacherRepository = teacherRepository;
        this.teacherPostRepository = teacherPostRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public ApplyPostEntity addApplyPost(ApplyPostEntity applyPost) {

        Calendar calendar = Calendar.getInstance() ;

        Long student_id  = applyPost.getStudentEntity().getStudent_id() ;
        Long post_id = applyPost.getTeacherPostEntity().getPost_id() ;

        ApplyPostEntity temp_apply = applyPost ;

        Optional<TeacherPostEntity> post = teacherPostRepository.findById(post_id);
        Optional<StudentEntity> student = studentRepository.findById(student_id);

        if(post.isPresent() && student.isPresent()) {
                temp_apply.setTeacherPostEntity(post.get());
                temp_apply.setStudentEntity(student.get());
                temp_apply.setStatus("waiting");
                temp_apply.setApplyDate(new Timestamp(calendar.getTimeInMillis()));

            return  applyPostRepostity.save(temp_apply) ;
        }
        else {
            return null ;
        }
    }

    @Override
//    for teacher to update
    public ApplyPostEntity updateStatusApplyPost(ApplyPostEntity applyPost , Long apply_id ) {
        Optional<ApplyPostEntity> applyPostFromDb = applyPostRepostity.findById(apply_id) ;

        ApplyPostEntity temp_apply = applyPostFromDb.get() ;
        temp_apply.setStatus(applyPost.getStatus());


//        return applyPostRepostity.save(temp_apply) ;
        return temp_apply ;
    }


    @Override
    public ApplyPostResponse getApplyPosts(String post_id) {
        Optional<TeacherPostEntity> teacherPost = teacherPostRepository.findById(Long.valueOf(post_id)) ;
        TeacherPostEntity temp_teacherPost = teacherPost.get() ;

        List<ApplyPostEntity> applyPostEntities = applyPostRepostity.getTeacherApplyPost(post_id);

        List<ApplyPostEntity> applies = new ArrayList<>();


        applies = applyPostEntities.stream()
                .map((applyPostEntity) ->
                        ApplyPostEntity.builder()
                                .apply_id(applyPostEntity.getApply_id())
                                .status(applyPostEntity.getStatus())
                                .applyDate(applyPostEntity.getApplyDate())
                                .build()
                ).collect(Collectors.toList());

        ApplyPostResponse applyPostResponse = new ApplyPostResponse( applies , temp_teacherPost );

        return applyPostResponse ;

    }




}
