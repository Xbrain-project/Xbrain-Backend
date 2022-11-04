package com.Xbrain.BackendXbrain.repository;

import com.Xbrain.BackendXbrain.entity.CommentEntity;
import com.Xbrain.BackendXbrain.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

//    List<CommentEntity> findByPostId(Long postId);
//
//    @Transactional
//    void deleteByPostId(long postId);
}