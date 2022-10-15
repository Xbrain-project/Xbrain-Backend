package com.Xbrain.BackendXbrain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class User
{
    private String id;
    private String username;
    private String name;
    private String email;
}
