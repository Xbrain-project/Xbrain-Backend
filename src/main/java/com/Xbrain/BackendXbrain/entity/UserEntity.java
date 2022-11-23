package com.Xbrain.BackendXbrain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id ;

        private String name ;
        private String email;
        private String password ;
        private String nickname;
        private String school;
        private String grade;
        private int phone;
        private String address;
        private String line;
        private String sex;
        private String status;
        private String intro;

        private String role;



}


