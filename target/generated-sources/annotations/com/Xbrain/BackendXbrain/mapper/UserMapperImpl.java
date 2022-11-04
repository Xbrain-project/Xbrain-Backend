package com.Xbrain.BackendXbrain.mapper;

import com.Xbrain.BackendXbrain.entity.UserEntity;
import com.Xbrain.BackendXbrain.model.Mresponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-04T09:18:50+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public Mresponse toResponse(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        Mresponse mresponse = new Mresponse();

        return mresponse;
    }
}
