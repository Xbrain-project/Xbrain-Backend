package com.Xbrain.BackendXbrain.repository;

import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
    @Query(value = "SELECT * FROM xbraindb.teachers a WHERE a.name = :name",
            nativeQuery = true)
    List<TeacherEntity> testGet(String name);

    @Query(value = "SELECT * FROM xbraindb.teachers a WHERE a.post_id = :post_id",
            nativeQuery = true)
    TeacherEntity deleteTeacherPost (Long post_id);

    @Query(value = "SELECT * FROM xbraindb.teachers a WHERE a.post_id = :post_id", nativeQuery = true)
    TeacherEntity findbyPostId ( Long post_id) ;

    TeacherEntity findByEmailAndPassword(String email, String password);



}

