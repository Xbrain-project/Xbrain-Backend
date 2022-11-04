package com.Xbrain.BackendXbrain.repository;
import com.Xbrain.BackendXbrain.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {

    Optional<PostEntity> findById(Long aLong);


}
