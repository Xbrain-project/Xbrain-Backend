package com.Xbrain.BackendXbrain.mapper;

import com.Xbrain.BackendXbrain.dto.CommentRequest;
import com.Xbrain.BackendXbrain.dto.MPostresponse;
import com.Xbrain.BackendXbrain.entity.CommentEntity;
import com.Xbrain.BackendXbrain.entity.PostEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-19T21:11:08+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public MPostresponse toPostResponse(PostEntity post) {
        if ( post == null ) {
            return null;
        }

        MPostresponse mPostresponse = new MPostresponse();

        mPostresponse.setTitle( post.getTitle() );
        mPostresponse.setUserEntity( post.getUserEntity() );

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
