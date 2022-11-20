package com.Xbrain.BackendXbrain.factory;

import com.Xbrain.BackendXbrain.services.BaseService;
import com.Xbrain.BackendXbrain.services.PostService;

public class PostBuilder {

    PostFactory postFactory = new PostFactory();

    BaseService pService = postFactory.getType("POST");



    //    public void setpService(BaseService pService) {
//        this.pService = pService;
//        pService.save(pService);
//    }
}
