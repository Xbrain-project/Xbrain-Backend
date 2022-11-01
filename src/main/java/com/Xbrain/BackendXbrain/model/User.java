package com.Xbrain.BackendXbrain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
public class User
{
    private Long id;
    private String username;
    private String name;
    private String email;
}
