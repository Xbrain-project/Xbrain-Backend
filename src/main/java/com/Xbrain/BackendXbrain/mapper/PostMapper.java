package com.Xbrain.BackendXbrain.mapper;

import com.Xbrain.BackendXbrain.dto.CommentRequest;
import com.Xbrain.BackendXbrain.dto.MPostresponse;

import com.Xbrain.BackendXbrain.entity.CommentEntity;
import com.Xbrain.BackendXbrain.entity.PostEntity;

import com.Xbrain.BackendXbrain.entity.UserEntity;
import org.mapstruct.Mapper;




@Mapper(componentModel = "spring")
public interface PostMapper {

    MPostresponse toPostResponse(PostEntity post, UserEntity user);

    CommentRequest toCommentRequest(CommentEntity comment);
}
