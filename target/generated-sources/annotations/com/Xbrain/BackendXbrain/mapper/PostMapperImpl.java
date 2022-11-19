package com.Xbrain.BackendXbrain.mapper;

import com.Xbrain.BackendXbrain.dto.CommentRequest;
import com.Xbrain.BackendXbrain.dto.MPostresponse;
import com.Xbrain.BackendXbrain.entity.CommentEntity;
import com.Xbrain.BackendXbrain.entity.PostEntity;
import com.Xbrain.BackendXbrain.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-19T21:55:03+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public MPostresponse toPostResponse(PostEntity post, UserEntity user) {
        if ( post == null && user == null ) {
            return null;
        }

        MPostresponse mPostresponse = new MPostresponse();

        if ( post != null ) {
            mPostresponse.setTitle( post.getTitle() );
            mPostresponse.setContent( post.getContent() );
        }
        if ( user != null ) {
            mPostresponse.setUsername( user.getUsername() );
        }

        return mPostresponse;
    }

    @Override
    public CommentRequest toCommentRequest(CommentEntity comment) {
        if ( comment == null ) {
            return null;
        }

        CommentRequest commentRequest = new CommentRequest();

        commentRequest.setContent( comment.getContent() );

        return commentRequest;
    }
}
