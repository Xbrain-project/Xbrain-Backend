package com.Xbrain.BackendXbrain.repository;
import com.Xbrain.BackendXbrain.entity.PostEntity;
import com.Xbrain.BackendXbrain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmailAndPassword(String email,String password);

    UserEntity findByEmail(String email);
}
