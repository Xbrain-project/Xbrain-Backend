package com.Xbrain.BackendXbrain.mapper;

import com.Xbrain.BackendXbrain.dto.CommentRequest;
import com.Xbrain.BackendXbrain.dto.MPostresponse;

import com.Xbrain.BackendXbrain.entity.CommentEntity;
import com.Xbrain.BackendXbrain.entity.PostEntity;

import org.mapstruct.Mapper;




@Mapper(componentModel = "spring")
public interface PostMapper {

    MPostresponse toPostResponse(PostEntity post);

    CommentRequest toCommentRequest(CommentEntity comment);
}
