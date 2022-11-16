package com.Xbrain.BackendXbrain.repository;

import com.Xbrain.BackendXbrain.entity.ApplyPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyPostRepostity extends JpaRepository<ApplyPostEntity,Long> {
}
