package com.Xbrain.BackendXbrain.services;



import com.Xbrain.BackendXbrain.entity.PostEntity;
import com.Xbrain.BackendXbrain.model.Post;
import com.Xbrain.BackendXbrain.repository.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post addPost(Post post) throws Exception {
        try {

            PostEntity postEntity = new PostEntity();
            BeanUtils.copyProperties(post, postEntity);
//            if (post.getFile() != null && !post.getFile().equalsIgnoreCase("null"))
//                postEntity.setImage(post.getFile());
//            else
//                postEntity.setImage(null);

            postRepository.save(postEntity);

            post.setId(postEntity.getId());


        } catch (Exception e) {
            throw new Exception("Could not save Post: " + e);
        }
        return post;
    }

    @Override
    public List<Post> getPost() {
        List<PostEntity> postEntities
                = postRepository.findAll();

        List<Post> posts = new ArrayList<>();
        posts = postEntities.stream()
                .map((postEntity) ->
                        Post.builder()
                                .id(postEntity.getId())
                                .timeStamp(postEntity.getTimeStamp())
                                .email(postEntity.getEmail())
                                .name(postEntity.getName())
                                .post(postEntity.getPost())
                                .build()
                ).collect(Collectors.toList());
        return posts;
    }


}