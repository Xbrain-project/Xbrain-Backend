package com.Xbrain.BackendXbrain.repository;

import com.Xbrain.BackendXbrain.entity.ApplyPostEntity;
import com.Xbrain.BackendXbrain.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface ApplyPostRepostity extends JpaRepository<ApplyPostEntity,Long> {
    @Query(
                value = "SELECT * FROM project.apply_posts a WHERE a.post_id = :post_id",
            nativeQuery = true)
    List<ApplyPostEntity> getTeacherApplyPost(Long post_id) ;

    @Query(value = "SELECT * FROM project.apply_posts a WHERE a.post_id = :post_id",
            nativeQuery = true)
    List<ApplyPostEntity> deleteTeacherPost (Long post_id);

    @Query(value = "SELECT * FROM project.apply_posts a WHERE a.student_id = :student_id",
            nativeQuery = true)
    List<ApplyPostEntity> getStudentApplyPost (Long student_id);

}
