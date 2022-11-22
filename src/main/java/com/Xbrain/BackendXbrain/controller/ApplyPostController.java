//package com.Xbrain.BackendXbrain.controller;
//
//import com.Xbrain.BackendXbrain.entity.ApplyPostEntity;
//import com.Xbrain.BackendXbrain.repository.ApplyPostRepostity;
//import com.Xbrain.BackendXbrain.services.ApplyPostService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class ApplyPostController {
//    ApplyPostService applyPostService;
//
//    public ApplyPostController(ApplyPostService applyPostService) {
//        this.applyPostService = applyPostService;
//    }
//
//
//    @PostMapping(path = "/createApplyPost")
//    ApplyPostEntity addApplyPost(@RequestBody ApplyPostEntity applyPost){
//        applyPost.setStatus("waiting");
//        return applyPostService.addApplyPost(applyPost);
//    }
//
//    @RestController
//    public static class ApplyPostController {
//        ApplyPostService applyPostService ;
//        ApplyPostRepostity applyPostRepostity ;
//
//    //    public ApplyPostController(ApplyPostService applyPostService) {
//    //        this.applyPostService = applyPostService;
//    //    }
//
//        public ApplyPostController(ApplyPostService applyPostService, ApplyPostRepostity applyPostRepostity) {
//            this.applyPostService = applyPostService;
//            this.applyPostRepostity = applyPostRepostity;
//        }
//
//        @PostMapping(path = "/createApplyPost")
//        ApplyPostEntity addApplyPost(@RequestBody ApplyPostEntity applyPostEntity){
//            return applyPostService.addApplyPost(applyPostEntity);
//        }
//
//    //    fix this shit !!!!!!!
//
//        @GetMapping(path = "/getTeacherApplyPost")
//        ApplyPostResponse getTeacherApplyPost (@RequestParam("post_id") String post_id) {
//    //        return  applyPostRepostity.getTeacherApplyPost(post_id);
//            return applyPostService.getApplyPosts(post_id) ;
//        }
//
//        @PutMapping(path = "/updateStatusApplyPost/{apply_id}")
//        ApplyPostEntity updateApplyPost(@RequestBody ApplyPostEntity updateApplyPost , @PathVariable("apply_id") Long apply_id ){
//
//            return applyPostService.updateStatusApplyPost(updateApplyPost , apply_id) ;
//        }
//
//
//
//
//    }
//}
