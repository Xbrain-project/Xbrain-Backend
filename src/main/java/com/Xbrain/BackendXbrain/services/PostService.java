package com.Xbrain.BackendXbrain.services;



import com.Xbrain.BackendXbrain.model.Post;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {
    Post addPost(Post post) throws Exception;

    List<Post> getPost();
}
