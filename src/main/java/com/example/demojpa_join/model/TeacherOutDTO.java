package com.example.demojpa_join.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeacherOutDTO {
    private Integer id;
    private String name;
    private Integer status;
    private CourseDTO course;

}
