package com.Xbrain.BackendXbrain.bussiness;

import com.Xbrain.BackendXbrain.dto.MPostresponse;
import com.Xbrain.BackendXbrain.entity.PostEntity;
import com.Xbrain.BackendXbrain.entity.UserEntity;
import com.Xbrain.BackendXbrain.exception.BaseException;
import com.Xbrain.BackendXbrain.mapper.PostMapper;
import com.Xbrain.BackendXbrain.repository.UserRepository;
import com.Xbrain.BackendXbrain.services.PostService;
import org.springframework.stereotype.Service;

@Service

public class PostBusiness implements PostMapper {

    private final PostMapper postMapper;


    public PostBusiness(PostMapper postMapper, PostService postService, UserRepository userRepository) {
        this.postMapper = postMapper;
        this.postService = postService;

    }
    private final PostService postService;

    public MPostresponse create(PostEntity request, Long userId) throws BaseException {

        PostEntity post = postService.addPost(userId,request.getTitle(),request.getContent());
        return postMapper.toPostResponse(post,post.getUserEntity());
    }

    public MPostresponse getPostById(String postId) {
       PostEntity post = postService.getPostById(postId);

        return postMapper.toPostResponse(post,post.getUserEntity());
    }

    @Override
    public MPostresponse toPostResponse(PostEntity post, UserEntity user) {
        return null;
    }


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
