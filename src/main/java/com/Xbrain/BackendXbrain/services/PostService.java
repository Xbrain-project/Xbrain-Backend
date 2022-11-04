package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.PostEntity;
import com.Xbrain.BackendXbrain.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostEntity addPost(String username, String description){
        PostEntity entity = new PostEntity();
        entity.setUsername(username);
        entity.setDescription(description);

        return postRepository.save(entity);
    }
}
