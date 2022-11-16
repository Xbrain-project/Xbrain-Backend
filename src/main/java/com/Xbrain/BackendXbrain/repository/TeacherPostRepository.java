package com.Xbrain.BackendXbrain.repository;

import com.Xbrain.BackendXbrain.entity.TeacherPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherPostRepository extends JpaRepository<TeacherPostEntity , Long > {
    @Query(value = "select * from teacher_posts \n" +
            "Where teacher_posts.open_coursesx REGEXP :courses \n" +
            "and teacher_posts.placesx REGEXP :places \n" +
            "and teacher_posts.student_classesx REGEXP :classes \n" +
            "and teacher_posts.teach_typesx REGEXP :types ",
        nativeQuery = true)
    List<TeacherPostEntity> searchTeacherPosts_courses (String courses , String places , String classes , String types )  ;
    // . Any single character
    // | instance match

}
