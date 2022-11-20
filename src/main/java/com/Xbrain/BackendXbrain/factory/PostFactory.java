package com.Xbrain.BackendXbrain.factory;

import com.Xbrain.BackendXbrain.entity.PostEntity;
import com.Xbrain.BackendXbrain.services.BaseService;
import com.Xbrain.BackendXbrain.services.PostService;

public class PostFactory {

    public BaseService getType(String type){

        if(type == null){
            return null;
        }
        if(type.equalsIgnoreCase("POST")){

            return new PostEntity();
        }

//        else if(type.equalsIgnoreCase("COMMENT")) {
//            return new CommentEntity();
//        }
        return null;
    }
}
