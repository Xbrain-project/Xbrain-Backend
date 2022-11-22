package com.Xbrain.BackendXbrain.dto;

import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
public class UpdateTeacherReq {
    private String name ;
    private String email ;
    private String password;
    private String school;
    private String nickname;
    private String sex;
    private String status;
    private String intro;
    private int phone;
    private String line;

    private Long id;
}
