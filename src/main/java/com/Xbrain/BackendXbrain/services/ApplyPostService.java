package com.Xbrain.BackendXbrain.services;

//import com.Xbrain.BackendXbrain.dto.ApplyPostRequest;
import com.Xbrain.BackendXbrain.dto.ApplyPostResponse;
import com.Xbrain.BackendXbrain.entity.ApplyPostEntity;
import com.Xbrain.BackendXbrain.entity.StudentEntity;
import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;
import com.Xbrain.BackendXbrain.repository.ApplyPostRepostity;

import java.util.List;

public interface ApplyPostService {
    ApplyPostEntity addApplyPost (ApplyPostEntity applyPost) ;

    ApplyPostEntity updateApplyPost (ApplyPostEntity applyPost);

    ApplyPostResponse getApplyPosts(String post_id);
}
