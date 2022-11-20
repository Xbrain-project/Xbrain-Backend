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
    List<TeacherPostEntity> searchTeacherPosts(String courses , String places , String classes , String types )  ;
    // . Any single character
    // | instance match

    @Query(value = "select * from teacher_posts \n" +
            "\n" +
            "inner join teacherpost_opencourses\n" +
            "ON teacher_posts.post_id = \tteacherpost_opencourses.teacher_post_entity_post_id \n" +
            "\n" +
            "inner join teacherpost_studentclasses\n" +
            "ON teacher_posts.post_id = \tteacherpost_studentclasses.teacher_post_entity_post_id \n" +
            "\n" +
            "inner join teacherpost_teachtypes\n" +
            "ON teacher_posts.post_id = \tteacherpost_teachtypes.teacher_post_entity_post_id \n" +
            "\n" +
            "inner join teacherpost_places\n" +
            "ON teacher_posts.post_id = \tteacherpost_places.teacher_post_entity_post_id \n" +
            "\n" +
            "where find_in_set(teacherpost_opencourses.open_course,:courses)",nativeQuery = true )
    List<TeacherPostEntity>  searchFromCourses(String courses );
//
//    @Query(value = "select * from teacherpost_places \n" +
//            "where find_in_set(teacherpost_places.place , :places)",nativeQuery = true )
//    List<TeacherPostEntity>  searchFromPlaces(String places);
//
//    @Query(value = "select * from teacherpost_studentclasses \n" +
//            "where find_in_set(teacherpost_studentclasses.student_class , :classes)",nativeQuery = true )
//    List<TeacherPostEntity>  searchFromClasses(String classes);
//
//    @Query(value = "select * from teacherpost_teachtypes \n" +
//            "where find_in_set(teacherpost_teachtypes.teach_type , :types ) ",nativeQuery = true )
//    List<TeacherPostEntity>  searchFromTypes(String types);

}
