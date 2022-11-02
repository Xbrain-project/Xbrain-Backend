package com.Xbrain.BackendXbrain.services;



import com.Xbrain.BackendXbrain.entity.PostEntity;

import com.Xbrain.BackendXbrain.entity.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface PostService {

    PostEntity addPost(PostEntity postEntity) throws Exception;

    List<PostEntity> getPost();

//    Optional<PostEntity> getPostById(Long id);
//
//    ResponseEntity<HttpStatus> deletePost(Long id);
//    Optional<PostEntity> findByUser(UserEntity user);
}
