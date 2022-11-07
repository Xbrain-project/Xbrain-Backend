package com.Xbrain.BackendXbrain.repository;

import com.Xbrain.BackendXbrain.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

      List<CommentEntity> findByPostEntityId(Long postId);

//    @Transactional
//    void deleteByPostId(long postId);
}