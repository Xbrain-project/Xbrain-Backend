package com.Xbrain.BackendXbrain.controller;

//import com.Xbrain.BackendXbrain.dto.ApplyPostRequest;
import com.Xbrain.BackendXbrain.dto.StudentApplyPostDTO;
import com.Xbrain.BackendXbrain.dto.TeacherApplyPostDTO;
import com.Xbrain.BackendXbrain.entity.ApplyPostEntity;
import com.Xbrain.BackendXbrain.repository.ApplyPostRepostity;
import com.Xbrain.BackendXbrain.services.ApplyPostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ApplyPostController {
    ApplyPostService applyPostService ;
    ApplyPostRepostity applyPostRepostity ;

//    public ApplyPostController(ApplyPostService applyPostService) {
//        this.applyPostService = applyPostService;
//    }

    public ApplyPostController(ApplyPostService applyPostService, ApplyPostRepostity applyPostRepostity) {
        this.applyPostService = applyPostService;
        this.applyPostRepostity = applyPostRepostity;
    }

    @PostMapping(path = "/testTong")
    String testTong(){
        return "helloworld" ;
    }
    @PostMapping(path = "/createApplyPost")
    ApplyPostEntity addApplyPost(@RequestBody ApplyPostEntity applyPostEntity){
        return applyPostService.addApplyPost(applyPostEntity);
    }

//    fix this shit !!!!!!!

    @GetMapping(path = "/getTeacherApplyPost/{teacher_id}")
    List<TeacherApplyPostDTO> getTeacherApplyPost (@PathVariable("teacher_id") Long teacher_id) {
//        return  applyPostRepostity.getTeacherApplyPost(post_id);
        return applyPostService.getApplyPosts(teacher_id) ;
    }

    @PutMapping(path = "/updateStatusApplyPost/{apply_id}")
    ApplyPostEntity updateApplyPost(@RequestBody ApplyPostEntity updateApplyPost , @PathVariable("apply_id") Long apply_id ){

        return applyPostService.updateStatusApplyPost(updateApplyPost , apply_id) ;
    }

    @GetMapping(path = "/getStudentApplyPost/{student_id}")
    List<StudentApplyPostDTO> getStudentApplyPost (@PathVariable("student_id") Long student_id) {
        return applyPostService.getStudentApplyPosts(student_id);
    }

}
