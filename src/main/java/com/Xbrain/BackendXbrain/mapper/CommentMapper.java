package com.Xbrain.BackendXbrain.mapper;
import com.Xbrain.BackendXbrain.dto.CommentRequest;
import com.Xbrain.BackendXbrain.dto.CommentResponse;
import com.Xbrain.BackendXbrain.entity.CommentEntity;
import com.Xbrain.BackendXbrain.entity.UserEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentRequest toCommentRequest(CommentEntity comment);

    CommentResponse toCommentResponse(CommentEntity comment,UserEntity user);

}
