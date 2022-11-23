package com.Xbrain.BackendXbrain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class UpdateStudentReq {

    private String name ;
    private String nickname;
    private String school;
    private String grade;
    private String email ;
    private int phone;
    private String address;
    private String line;

    private Long id;

}
