package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.ApplyPostEntity;

public interface ApplyPostService {
    ApplyPostEntity studentApply(Long postId) ;
    ApplyPostEntity teacherApply(Long postId) ;

    ApplyPostEntity addApplyForm() ;

}
