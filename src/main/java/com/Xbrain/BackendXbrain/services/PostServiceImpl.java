package com.Xbrain.BackendXbrain.services;



import com.Xbrain.BackendXbrain.entity.PostEntity;

import com.Xbrain.BackendXbrain.repository.PostRepository;
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

    @Override
    public PostEntity addPost(PostEntity postEntity) throws Exception {

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

        return  postRepository.save(postEntity);
    }

    @Override
    public ResponseEntity<Optional<PostEntity>> getPostById(Long id) {
        Optional<PostEntity> postEntity = postRepository.findById(id);
         return  ResponseEntity.ok(postEntity);
    }

    @Override
    public List<PostEntity> getPost() {
        List<PostEntity> postEntities
                = postRepository.findAll();

        List<PostEntity> posts = new ArrayList<>();
        posts = postEntities.stream()
                .map((postEntity) ->
                        PostEntity.builder()
                                .postId(postEntity.getPostId())
                                .TimeStamp(postEntity.getTimeStamp())
                                .email(postEntity.getEmail())
                                .name(postEntity.getName())
                                .post(postEntity.getPost())
                                .build()
                ).collect(Collectors.toList());
        return posts;
    }


}