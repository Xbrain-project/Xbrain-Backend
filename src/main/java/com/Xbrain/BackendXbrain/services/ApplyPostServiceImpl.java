package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.ApplyPostEntity;
import com.Xbrain.BackendXbrain.repository.ApplyPostRepostity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyPostServiceImpl implements ApplyPostService{
    @Autowired
    ApplyPostRepostity applyPostRepostity ;

    @Autowired
    public ApplyPostServiceImpl(ApplyPostRepostity applyPostRepostity) {
        this.applyPostRepostity = applyPostRepostity;
    }

    @Override
    public ApplyPostEntity addApplyPost(ApplyPostEntity applyPost) {

        return applyPostRepostity.save(applyPost) ;
    }
}
