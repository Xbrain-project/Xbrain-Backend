package com.Xbrain.BackendXbrain.dto;

import com.Xbrain.BackendXbrain.entity.UserEntity;
import lombok.Data;

@Data
public class MPostresponse {
    private String title;
    private String content;
    private String username;
}

