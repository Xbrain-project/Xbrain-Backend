package com.Xbrain.BackendXbrain.dto;

import lombok.Data;

@Data
public class TeacherApplyPostDTO {
    // student data
    private String studentName ;
    // apply post data
    private String course ;
    private String teachType ;
    private String price ;
    private String place ;
    private String status ;

}
