package com.Xbrain.BackendXbrain.dto;

import com.Xbrain.BackendXbrain.entity.UserEntity;
import lombok.Data;

@Data
public class PostRequest {
    private String title;
    private String content;
    private String email;

}

