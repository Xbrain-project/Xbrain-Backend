package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.dto.CommentResponse;
import com.Xbrain.BackendXbrain.entity.CommentEntity;
import com.Xbrain.BackendXbrain.entity.PostEntity;
import com.Xbrain.BackendXbrain.entity.UserEntity;
import com.Xbrain.BackendXbrain.repository.CommentRepository;
import com.Xbrain.BackendXbrain.repository.PostRepository;
import com.Xbrain.BackendXbrain.repository.UserRepository;
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
    @Autowired
    UserRepository userRepository;

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    public CommentEntity create(String content, String postId,  String email){
        Optional<PostEntity> post = postRepository.findById(postId);
        UserEntity user = userRepository.findByEmail(email);

        CommentEntity comment = new CommentEntity();
        comment.setContent(content);
        comment.setPostEntity(post.get());
        comment.setUserEntity(user);

        return commentRepository.save(comment);
    }

    public ResponseEntity<Optional<CommentEntity>> getCommentById(String id) {
        Optional<CommentEntity> commentEntity = commentRepository.findById(id);
        return  ResponseEntity.ok(commentEntity);
    }

    public List<CommentEntity> getAllCommentsByPostId(String postId) {
//        if (!postRepository.existsById(postId)) {
//            throw new ResourceNotFoundException("Not found Tutorial with id = " + postId);
//        }

        List<CommentEntity> comments = commentRepository.findByPostEntityId(postId);

        return comments;
    }



    public ResponseEntity<HttpStatus> deleteComment(String id) {
        commentRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
