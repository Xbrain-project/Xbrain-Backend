package com.Xbrain.BackendXbrain.dto;

import com.Xbrain.BackendXbrain.entity.CommentEntity;
import com.Xbrain.BackendXbrain.entity.UserEntity;
import lombok.Data;

import java.util.List;

@Data
public class Comments {
    private List<CommentEntity> comment;
    private String name;
}

