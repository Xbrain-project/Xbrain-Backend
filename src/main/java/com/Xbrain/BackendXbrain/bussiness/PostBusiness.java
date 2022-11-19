package com.Xbrain.BackendXbrain.bussiness;

import com.Xbrain.BackendXbrain.dto.MPostresponse;
import com.Xbrain.BackendXbrain.entity.PostEntity;
import com.Xbrain.BackendXbrain.exception.BaseException;
import com.Xbrain.BackendXbrain.mapper.PostMapper;
import com.Xbrain.BackendXbrain.services.PostService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class PostBusiness {

    private final PostMapper postMapper;
    private final PostService postService;

    public PostBusiness(PostMapper postMapper, PostService postService) {
        this.postMapper = postMapper;
        this.postService = postService;
    }


    public MPostresponse create(PostEntity request, Long userId) throws BaseException {

        PostEntity post = postService.addPost(userId,request.getContent(),request.getTitle());

        return postMapper.toPostResponse(post);
    }

//    public String getPostById(String id) {
//        //get data from DB
//
//
//        return id;
//
//    }


//    public String uploadProfilePicture(MultipartFile file) throws BaseException {
//        // validate file
//        if (file == null) {
//            // throw error
//            throw FileException.fileNull();
//        }
//
//        // validate size
//        if (file.getSize() > 1048576 * 2) {
//            // throw error
//            throw FileException.fileMaxSize();
//        }
//
//        String contentType = file.getContentType();
//        if (contentType == null) {
//            // throw error
//            throw FileException.unsupported();
//        }
//
//        List<String> supportedTypes = Arrays.asList("image/jpeg", "image/png");
//        if (!supportedTypes.contains(contentType)) {
//            // throw error (unsupport)
//            throw FileException.unsupported();
//        }
//
//        // TODO: upload file File Storage (AWS S3, etc...)
//        try {
//            byte[] bytes = file.getBytes();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "";
//    }

}
