package com.Xbrain.BackendXbrain.repository;

import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;
import com.Xbrain.BackendXbrain.model.TeacherPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherPostRepository extends JpaRepository<TeacherPost,Long>{

    @Query(value = "SELECT * FROM teacher_posts p WHERE " +
            "p.user_name LIKE CONCAT('%',:query, '%')" +
            "Or p.description LIKE CONCAT('%',:query, '%')" , nativeQuery = true)
    List<TeacherPost> searchTeacherPost(String query);

//    @Query(value = "SELECT * FROM teacher_post p WHERE " +
//            "p.post_id LIKE CONCAT('%',:query, '%')"
//           , nativeQuery = true)
//    List<TeacherPost> searchByIdTeacherPost (Long id);
}
