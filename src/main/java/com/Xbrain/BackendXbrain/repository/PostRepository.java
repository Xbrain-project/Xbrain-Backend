package com.Xbrain.BackendXbrain.repository;
import com.Xbrain.BackendXbrain.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {




}
