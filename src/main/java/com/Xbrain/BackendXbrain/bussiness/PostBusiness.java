//package com.Xbrain.BackendXbrain.bussiness;
//
//import com.Xbrain.BackendXbrain.entity.PostEntity;
//import com.Xbrain.BackendXbrain.exception.BaseException;
//import com.Xbrain.BackendXbrain.exception.FileException;
//import com.Xbrain.BackendXbrain.services.PostService;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class PostBusiness {
//
//    private final PostService postService;
//
//    public PostBusiness(PostService postService) {
//        this.postService = postService;
//    }
//
//
//
//    public String getPostById(String id) {
//        //get data from DB
//
//
//        return id;
//
//    }
//
//
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
//
//}
