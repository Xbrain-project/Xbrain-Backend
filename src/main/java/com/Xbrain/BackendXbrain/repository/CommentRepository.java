package com.Xbrain.BackendXbrain.repository;

import com.Xbrain.BackendXbrain.entity.CommentEntity;
import com.Xbrain.BackendXbrain.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

}