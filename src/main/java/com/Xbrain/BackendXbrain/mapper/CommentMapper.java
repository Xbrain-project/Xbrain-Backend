package com.Xbrain.BackendXbrain.mapper;
import com.Xbrain.BackendXbrain.dto.CommentRequest;
import com.Xbrain.BackendXbrain.dto.CommentResponse;
import com.Xbrain.BackendXbrain.dto.Comments;
import com.Xbrain.BackendXbrain.entity.CommentEntity;
import com.Xbrain.BackendXbrain.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentRequest toCommentRequest(CommentEntity comment);

    CommentResponse toCommentResponse(CommentEntity comment,UserEntity user);

//    Comments toComments(CommentEntity comment);
//    List<CommentEntity> toComments(CommentEntity value);


}
