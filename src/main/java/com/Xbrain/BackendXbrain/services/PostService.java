package com.Xbrain.BackendXbrain.services;



import com.Xbrain.BackendXbrain.entity.PostEntity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Optional;

public interface PostService {

    PostEntity addPost(PostEntity post) throws Exception;

    ArrayList<PostEntity> getPost();

    ResponseEntity<Optional<PostEntity>> getPostById(Long id);

    ResponseEntity<HttpStatus> deletePost(Long id);
}
