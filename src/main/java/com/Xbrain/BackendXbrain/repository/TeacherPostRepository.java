package com.Xbrain.BackendXbrain.repository;

import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherPostRepository extends JpaRepository<TeacherPostEntity , Long > {
@Query(value = "SELECT * FROM project.teacher_posts t WHERE t.description = :post_id",
        nativeQuery = true)
    List<TeacherPostEntity> searchByDescTeacherPost (String post_id)  ;

}
