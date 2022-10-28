package com.Xbrain.BackendXbrain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;




@Entity
@Table(name = "post_commu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity implements Serializable {

    @Id
    @GeneratedValue
//    @Column(name = "POST_ID")
    private Long postId;
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
//    @ManyToOne
//    private UserEntity userId;
    private String user_id;
    @Lob
    private String description;

    private Timestamp timestamp;





}