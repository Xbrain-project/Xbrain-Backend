package com.Xbrain.BackendXbrain.dto;

import com.Xbrain.BackendXbrain.entity.CommentEntity;
import lombok.Data;

@Data
public class CommentRequest {
    private String content;
    private String email;

}
