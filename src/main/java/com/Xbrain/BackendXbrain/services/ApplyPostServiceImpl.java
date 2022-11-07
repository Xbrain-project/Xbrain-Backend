package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.ApplyPostEntity;
import com.Xbrain.BackendXbrain.entity.StudentEntity;
import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;
import com.Xbrain.BackendXbrain.repository.ApplyPostRepostity;
import com.Xbrain.BackendXbrain.repository.TeacherPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
