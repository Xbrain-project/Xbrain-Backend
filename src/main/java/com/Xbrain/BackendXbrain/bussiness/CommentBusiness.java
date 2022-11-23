package com.Xbrain.BackendXbrain.bussiness;

import com.Xbrain.BackendXbrain.dto.CommentRequest;
import com.Xbrain.BackendXbrain.dto.CommentResponse;
import com.Xbrain.BackendXbrain.entity.CommentEntity;
import com.Xbrain.BackendXbrain.exception.BaseExceptionImpl;
import com.Xbrain.BackendXbrain.mapper.CommentMapper;
import com.Xbrain.BackendXbrain.services.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentBusiness {
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    public CommentBusiness(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    public CommentResponse create(String postId, CommentRequest request) throws BaseExceptionImpl {
        CommentEntity comment = commentService.create(request.getContent(),postId, request.getEmail());
        return commentMapper.toCommentResponse(comment,comment.getUserEntity());
    }

    public CommentResponse getCommentById(String commentId) {
        CommentEntity comment = commentService.getCommentById(commentId);
        return commentMapper.toCommentResponse(comment,comment.getUserEntity());
    }

    public List<CommentEntity> getAllCommentsbyId(String postId) {
        List<CommentEntity> allCommentsByPostId = commentService.getAllCommentsByPostId(postId);
        return commentMapper.toComments(allCommentsByPostId);
    }

}
