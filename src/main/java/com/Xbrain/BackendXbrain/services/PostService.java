package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.PostEntity;
import com.Xbrain.BackendXbrain.repository.PostRepository;
import com.Xbrain.BackendXbrain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    UserRepository userRepository;

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public ResponseEntity<Optional<Object>> addPost(Long userId, PostEntity postRequest){
        Optional<Object> post = userRepository.findById(userId).map(User ->{
            postRequest.setUserEntity(User);

            return postRepository.save(postRequest);
        });

        return ResponseEntity.ok(post);
    }

    public List<PostEntity> getAllPosts(){
        List<PostEntity> posts = new ArrayList<PostEntity>();

        postRepository.findAll().forEach(posts::add);

        return posts;
    }

}
