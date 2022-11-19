package com.Xbrain.BackendXbrain.dto;

import com.Xbrain.BackendXbrain.entity.CommentEntity;
import com.Xbrain.BackendXbrain.entity.UserEntity;
import lombok.Data;

@Data
public class CommentResponse {
    private String content;
    private String username;
}
