package com.Xbrain.BackendXbrain.mapper;

import com.Xbrain.BackendXbrain.dto.CommentRequest;
import com.Xbrain.BackendXbrain.dto.CommentResponse;
import com.Xbrain.BackendXbrain.entity.CommentEntity;
import com.Xbrain.BackendXbrain.entity.UserEntity;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-21T04:59:59+0700",
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
            if ( comment.getDataCreated() != null ) {
                commentResponse.setDataCreated( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( comment.getDataCreated() ) );
            }
        }
        if ( user != null ) {
            commentResponse.setUsername( user.getUsername() );
        }

        return commentResponse;
    }

    @Override
    public List<CommentEntity> toComments(List<CommentEntity> value) {
        if ( value == null ) {
            return null;
        }

        List<CommentEntity> list = new ArrayList<CommentEntity>( value.size() );
        for ( CommentEntity commentEntity : value ) {
            list.add( commentEntity );
        }

        return list;
    }
}
