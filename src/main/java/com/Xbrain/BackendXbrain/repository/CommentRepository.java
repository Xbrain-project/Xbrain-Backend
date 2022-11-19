package com.Xbrain.BackendXbrain.repository;

import com.Xbrain.BackendXbrain.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, String> {

      // find comment by postID
      List<CommentEntity> findByPostEntityId(String postId);

    @Transactional
    void deleteByPostEntityId(long postId);
}