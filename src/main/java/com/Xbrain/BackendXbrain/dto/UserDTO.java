package com.Xbrain.BackendXbrain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

        private Long id ;
        private String name ;
        private String email;
        private String password ;
        private String nickname;
        private String Nschool;
        private String grade;
        private int phone;
        private String address;
        private String line;
        private String sex;
        private String status;
        private String intro;


        private String role;
}
