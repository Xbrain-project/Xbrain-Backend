package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.CommentEntity;
import com.Xbrain.BackendXbrain.repository.CommentRepository;
import com.Xbrain.BackendXbrain.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    PostRepository postRepository;

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    public ResponseEntity<Optional<Object>> create(Long postId, CommentEntity commentRequest){
        Optional<Object> comment = postRepository.findById(postId).map(Post ->{
            commentRequest.setPostEntity(Post);
            return commentRepository.save(commentRequest);
        });

        return ResponseEntity.ok(comment);
    }

    public ResponseEntity<Optional<CommentEntity>> getCommentById(Long id) {
        Optional<CommentEntity> commentEntity = commentRepository.findById(id);
        return  ResponseEntity.ok(commentEntity);
    }

    public List<CommentEntity> getAllCommentsByPostId(Long postId) {
//        if (!postRepository.existsById(postId)) {
//            throw new ResourceNotFoundException("Not found Tutorial with id = " + postId);
//        }

        List<CommentEntity> comments = commentRepository.findByPostEntityId(postId);

        return comments;
    }

    public ResponseEntity<HttpStatus> deleteComment(Long id) {
        commentRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
