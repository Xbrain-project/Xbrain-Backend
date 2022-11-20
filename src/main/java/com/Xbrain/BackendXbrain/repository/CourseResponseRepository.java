//package com.Xbrain.BackendXbrain.repository;
//
//import com.Xbrain.BackendXbrain.dto.CourseResponse;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface CourseResponseRepository extends JpaRepository<CourseResponse , Long> {
//    @Query(value = "select * from teacherpost_opencourses \n" +
//            "where find_in_set(teacherpost_opencourses.open_course , :courses ) ",nativeQuery = true )
//    List<CourseResponse> searchFromCourses(String courses);
//}
