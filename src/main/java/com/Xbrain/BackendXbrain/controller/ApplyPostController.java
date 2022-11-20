package com.Xbrain.BackendXbrain.controller;

import com.Xbrain.BackendXbrain.entity.ApplyPostEntity;
import com.Xbrain.BackendXbrain.services.ApplyPostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplyPostController {
    ApplyPostService applyPostService;

    public ApplyPostController(ApplyPostService applyPostService) {
        this.applyPostService = applyPostService;
    }


    @PostMapping(path = "/createApplyPost")
    ApplyPostEntity addApplyPost(@RequestBody ApplyPostEntity applyPost){
        applyPost.setStatus("waiting");
        return applyPostService.addApplyPost(applyPost);
    }

}
