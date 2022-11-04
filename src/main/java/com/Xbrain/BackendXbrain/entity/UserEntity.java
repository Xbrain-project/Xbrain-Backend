package com.Xbrain.BackendXbrain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "users")

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

//    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private List<PostEntity> posts;

    private String username;
    private String name;
    private String email;
}
