package com.Xbrain.BackendXbrain.dto;

import lombok.Data;

@Data
public class CommentResponse {
    private String content;
    private String username;
    private String dataCreated;
}
