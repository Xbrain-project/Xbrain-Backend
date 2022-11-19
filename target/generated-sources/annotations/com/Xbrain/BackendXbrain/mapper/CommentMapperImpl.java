package com.Xbrain.BackendXbrain.mapper;

import com.Xbrain.BackendXbrain.dto.CommentRequest;
import com.Xbrain.BackendXbrain.dto.CommentResponse;
import com.Xbrain.BackendXbrain.entity.CommentEntity;
import com.Xbrain.BackendXbrain.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-19T21:11:08+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public CommentRequest toCommentRequest(CommentEntity comment) {
        if ( comment == null ) {
            return null;
        }

        CommentRequest commentRequest = new CommentRequest();

        commentRequest.setContent( comment.getContent() );

        return commentRequest;
    }

    @Override
    public CommentResponse toCommentResponse(CommentEntity comment, UserEntity user) {
        if ( comment == null && user == null ) {
            return null;
        }

        CommentResponse commentResponse = new CommentResponse();

        if ( comment != null ) {
            commentResponse.setContent( comment.getContent() );
        }
        if ( user != null ) {
            commentResponse.setName( user.getName() );
        }

        return commentResponse;
    }
}
