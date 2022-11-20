package com.Xbrain.BackendXbrain.mapper;

import com.Xbrain.BackendXbrain.dto.MPostresponse;
import com.Xbrain.BackendXbrain.entity.PostEntity;
import com.Xbrain.BackendXbrain.entity.UserEntity;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-21T04:59:59+0700",
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
            if ( post.getDataCreated() != null ) {
                mPostresponse.setDataCreated( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( post.getDataCreated() ) );
            }
        }
        if ( user != null ) {
            mPostresponse.setUsername( user.getUsername() );
        }

        return mPostresponse;
    }
}
