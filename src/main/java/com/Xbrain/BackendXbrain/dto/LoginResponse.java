package com.Xbrain.BackendXbrain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponse {
        private Long id ;
        private String name ;
        private String email;

        private String role;
}
