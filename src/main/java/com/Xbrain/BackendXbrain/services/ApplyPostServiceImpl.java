package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.ApplyPostEntity;
import com.Xbrain.BackendXbrain.repository.ApplyPostRepostity;

public class ApplyPostServiceImpl implements ApplyPostService{

    ApplyPostRepostity applyPostRepostity ;

    public ApplyPostServiceImpl(ApplyPostRepostity applyPostRepostity) {
        this.applyPostRepostity = applyPostRepostity;
    }

    @Override
    public ApplyPostEntity studentApply(Long postId) {

        return null;
    }

    @Override
    public ApplyPostEntity teacherApply(Long postId) {

        return null;
    }

    @Override
    public ApplyPostEntity addApplyForm() {
        return null;
    }
}
