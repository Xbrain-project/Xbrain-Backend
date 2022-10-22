package com.Xbrain.BackendXbrain.services;



import com.Xbrain.BackendXbrain.entity.PostEntity;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PostService {
    PostEntity addPost(PostEntity post) throws Exception;

    ResponseEntity<Optional<PostEntity>> getPostById(Long id);

    List<PostEntity> getPost();
}
