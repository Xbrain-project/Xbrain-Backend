package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.CommentEntity;
import com.Xbrain.BackendXbrain.entity.PostEntity;
import com.Xbrain.BackendXbrain.repository.CommentRepository;
import com.Xbrain.BackendXbrain.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestService {

    private final PostRepository postRepository;

    private final CommentRepository commentRepository;

    public TestService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }


    public Object getEntityById(String type, String id){
        if (type == "POST") {
            Optional<PostEntity> postById = postRepository.findById(id);
            PostEntity post = postById.get();
            return post;
        }
        else if (type == "COMMENT") {
            Optional<CommentEntity> commentById = commentRepository.findById(id);
            CommentEntity comment = commentById.get();
            return comment;
        }

        return null;
    }
}
