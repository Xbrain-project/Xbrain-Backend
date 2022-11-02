package com.Xbrain.BackendXbrain.services;



import com.Xbrain.BackendXbrain.entity.PostEntity;

import com.Xbrain.BackendXbrain.entity.UserEntity;
import com.Xbrain.BackendXbrain.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Autowired
    UserService userService;

    @Override
    public PostEntity addPost(PostEntity postEntity) throws Exception {
//
//        try {
//            PostEntity postEntity = new PostEntity();
//            BeanUtils.copyProperties(post, postEntity);
//            if (post.getFile() != null && !post.getFile().equalsIgnoreCase("null"))
//                postEntity.setImage(post.getFile());
//            else
//                postEntity.setImage(null);
//            post.setId(postEntity.getId());
//        } catch (Exception e) {
//            throw new Exception("Could not save Post: " + e);
//        }

        PostEntity entity = new PostEntity();
        entity.setUserEntity(postEntity.getUserEntity());

//
        return  postRepository.save(entity);
    }



//    public PostEntity addPost( ) throws Exception {
//
//
//        // save
//        PostEntity postEntity = new PostEntity();
//        postEntity.setPostId(postEntity.getPostId());
//        postEntity.setPassword(passwordEncoder.encode(password));
//        postEntity.setName(name);
//        postEntity.setToken(token);
//        postEntity.setTokenExpire(tokenExpireDate);
//
//        return repository.save(entity);
//    }


//
//    @Override
//    public List<PostEntity> getPost() {
//        List<PostEntity> postList = postRepository.findAll();
//
//
//
//        for(int i=0;i<postList.size();i++){
//        PostEntity postItem = postList.get(i);
//
//
//            userService.getUserById(postItem.getUser_id()).
//    }
//        return postList;
//        return postRepository.findAll();
//    }

    @Override
    public List<PostEntity> getPost() {
        List<PostEntity> postEntities = postRepository.findAll();

//        for(int i=0;i<postEntities.size();i++){
//            PostEntity postItem = postEntities.get(i);
//
//            postItem.setUsername(userService.getUserById(postItem.getUser_id()));
//        }

        List<PostEntity> posts = new ArrayList<>();
        posts = postEntities.stream()
                .map((postEntity) ->
                        PostEntity.builder()
                                .postId(postEntity.getPostId())
                                .timestamp(postEntity.getTimestamp())
                                .username(postEntity.getUsername())
                                .description(postEntity.getDescription())
                                .build()

                ).collect(Collectors.toList());


        return posts;
    }



//    @Override
//    public ResponseEntity<Optional<PostEntity>> getPostById(Long id) {
//        Optional<PostEntity> postEntity = postRepository.findById(id);
//        return  ResponseEntity.ok(postEntity);
//    }


//    @Override
//    public Optional<PostEntity> getPostById(Long id) {
//        return  postRepository.findById(id);
//    }

//    @Override
//    public Optional<PostEntity> findByUser(UserEntity user) {
//        return  postRepository.findByUser
//    }


//    @Override
//    public ResponseEntity<HttpStatus> deletePost(Long id) {
//
//        postRepository.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

}