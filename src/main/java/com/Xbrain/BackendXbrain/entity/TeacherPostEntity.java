package com.Xbrain.BackendXbrain.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Table(name = "teacherPosts")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
@Getter
@Setter
public class TeacherPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id ;

    private String description ;
    @ElementCollection
    @CollectionTable(name = "teacherpost_opencourses")
    private List<String> openCourse;
    @ElementCollection
    @CollectionTable(name = "teacherpost_studentclasses")

    private List<String> studentClass ;
    @ElementCollection
    @CollectionTable(name = "teacherpost_teachtypes")
    private List<String> teachType ;
    @ElementCollection
    @CollectionTable(name = "teacherpost_places")
    private List<String> place ;
    @ElementCollection
    @CollectionTable(name = "teacherpost_freetimes")
    private List<String> freeTime;

    private String openCoursesX;
    private String studentClassesX ;
    private String teachTypesX ;
    private String placesX ;
    private String freeTimesX;

    private String price ;
    private Boolean allowshow ;
    private Timestamp createDate ;



}
