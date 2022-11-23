package com.Xbrain.BackendXbrain.repository;
import com.Xbrain.BackendXbrain.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<PostEntity, String> {

    PostEntity save(PostEntity entity);
    List<PostEntity> findAll();

}