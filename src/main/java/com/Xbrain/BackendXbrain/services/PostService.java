package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.PostEntity;
import com.Xbrain.BackendXbrain.entity.UserEntity;
import com.Xbrain.BackendXbrain.exception.BaseException;
import com.Xbrain.BackendXbrain.repository.PostRepository;
import com.Xbrain.BackendXbrain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public PostEntity addPost(Long userId, String title, String content) throws BaseException {

        // validate

//        if (Objects.isNull(postRequest.getContent())) {
//            throw PostException.createContentNull();
//        }

//        Optional<Object> post = userRepository.findById(userId).map(User ->{
//            postRequest.setUserEntity(User);
//
//            return postRepository.save(postRequest);
//        });


        Optional<UserEntity> user = userRepository.findById(userId);

        PostEntity post = new PostEntity();
        post.setTitle(title);
        post.setContent(content);
        post.setUserEntity(user.get());


        return postRepository.save(post);
    }

//        Optional<UserEntity> user = userRepository.findById(userId);
//        Post entity = new Post.Builder()
//                .id(postRequest.getId())
//                .title(postRequest.getTitle())
//                .content(postRequest.getContent())
//                .userEntity(user)
//                .build();
//        return postRepository.save(entity);
//    }

    public List<PostEntity> getAllPosts(){
        List<PostEntity> posts = new ArrayList<PostEntity>();

        postRepository.findAll().forEach(posts::add);

//        if (posts.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }

        return posts;
    }

    public ResponseEntity<Optional<PostEntity>> getPostById(String id) {
        Optional<PostEntity> postEntity = postRepository.findById(id);
        return  ResponseEntity.ok(postEntity);
    }

//    public ResponseEntity<HttpStatus> deletePost(String id) {
//        postRepository.deleteById(id);
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }



}
