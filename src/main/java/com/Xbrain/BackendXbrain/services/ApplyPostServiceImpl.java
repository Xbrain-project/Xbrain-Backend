package com.Xbrain.BackendXbrain.services;

//import com.Xbrain.BackendXbrain.dto.ApplyPostRequest;
import com.Xbrain.BackendXbrain.dto.ApplyPostResponse;
import com.Xbrain.BackendXbrain.dto.StudentApplyPostDTO;
import com.Xbrain.BackendXbrain.dto.TeacherApplyPostDTO;
import com.Xbrain.BackendXbrain.entity.ApplyPostEntity;
import com.Xbrain.BackendXbrain.entity.StudentEntity;
import com.Xbrain.BackendXbrain.entity.TeacherEntity;
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
        applyPostRepostity.save(temp_apply);

//        return applyPostRepostity.save(temp_apply) ;
        return temp_apply ;
    }

    @Override
    public List<TeacherApplyPostDTO> getApplyPosts(Long teacher_id) {
        // teacher -> post_id -> apply -> student
        Optional<TeacherEntity> teacher = teacherRepository.findById(teacher_id) ;
        TeacherEntity temp_teacher = teacher.get() ;
        Long post_id = temp_teacher.getTeacherPostEntity().getPost_id() ;
        List<StudentEntity> students = new ArrayList<>() ;
        List<ApplyPostEntity> studentApplyPosts = applyPostRepostity.getTeacherApplyPost(post_id) ;
        List<TeacherApplyPostDTO> teacherApplyPostDTOSList = new ArrayList<>() ;

        int i = 0 ;
        while(i < studentApplyPosts.size()) {
            TeacherApplyPostDTO tadto = new TeacherApplyPostDTO() ;
            students.add(studentApplyPosts.get(i).getStudentEntity()) ;

            tadto.setStudentName(students.get(i).getName());
            tadto.setCourse(studentApplyPosts.get(i).getCourse());
            tadto.setTeachType(studentApplyPosts.get(i).getTeachType());
            tadto.setPrice(studentApplyPosts.get(i).getPrice());
            tadto.setPlace(studentApplyPosts.get(i).getPlace());
            tadto.setStatus(studentApplyPosts.get(i).getStatus());

            teacherApplyPostDTOSList.add(tadto);
            i = i + 1 ;
        }

         return teacherApplyPostDTOSList ;
    }

    @Override
    public List<StudentApplyPostDTO> getStudentApplyPosts(Long student_id) {

        List<ApplyPostEntity> studentApplyPosts = applyPostRepostity.getStudentApplyPost(student_id) ;

        List<TeacherPostEntity> teacherPosts = new ArrayList<>() ;
        List<TeacherEntity> teacherEntities = new ArrayList<>();
        List<Long> posts_id = new ArrayList<>() ;
        List<StudentApplyPostDTO> studentApplyPostDTOList = new ArrayList<>() ;

        int i = 0 ;

        while(i < studentApplyPosts.size()) {
            StudentApplyPostDTO sdto = new StudentApplyPostDTO() ;
            teacherPosts.add(studentApplyPosts.get(i).getTeacherPostEntity());
            posts_id.add(teacherPosts.get(i).getPost_id());
            TeacherEntity teacher = teacherRepository.findbyPostId(posts_id.get(i));
            teacherEntities.add(teacher) ;
            sdto.setTeacherName(teacherEntities.get(i).getName());
            sdto.setCourse(studentApplyPosts.get(i).getCourse());
            sdto.setTeachType(studentApplyPosts.get(i).getTeachType());
            sdto.setPrice(studentApplyPosts.get(i).getPrice());
            sdto.setPlace(studentApplyPosts.get(i).getPlace());
            sdto.setStatus(studentApplyPosts.get(i).getStatus());

            studentApplyPostDTOList.add(sdto);
            i = i + 1 ;
        }

        return studentApplyPostDTOList;

    }


}
