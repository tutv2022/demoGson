package com.example.demojpa_join.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeacherDTO {
    private Integer id;
    //private Long courseId;
    private String name;
    private Integer status;
    private CourseReferenceDTO course;

}
