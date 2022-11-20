package com.Xbrain.BackendXbrain.dto;

import lombok.Data;

@Data
public class SelectPostResponse {
    private String title;
    private String content;
    private String username;
    private String dataCreated;
}
