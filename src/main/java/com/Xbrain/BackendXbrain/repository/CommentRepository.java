package com.Xbrain.BackendXbrain.repository;

import com.Xbrain.BackendXbrain.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

      // find comment by postID
      List<CommentEntity> findByPostEntityId(Long postId);

    @Transactional
    void deleteByPostEntityId(long postId);
}