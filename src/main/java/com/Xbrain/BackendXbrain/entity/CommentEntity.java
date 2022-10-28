package com.Xbrain.BackendXbrain.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Comment")
public class CommentEntity {

    @Id
    @GeneratedValue
    private Long commentID;
//    @OneToMany
//    private UserEntity userEntity;
//
//    @OneToMany
//    private PostEntity postEntity;

    private String user_id;
    private String comment;
    private Timestamp timestamp;
}
