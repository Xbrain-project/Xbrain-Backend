package com.Xbrain.BackendXbrain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
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


