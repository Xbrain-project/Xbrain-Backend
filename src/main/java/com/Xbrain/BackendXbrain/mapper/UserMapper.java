package com.Xbrain.BackendXbrain.mapper;


import com.Xbrain.BackendXbrain.entity.UserEntity;
import com.Xbrain.BackendXbrain.model.Mresponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    Mresponse toResponse(UserEntity user);
}
