package com.example.demojpa_join.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CourseOutputDTO {
    private Long id;
    private String name;
    private List<TeacherOutSimpleDTO> teachers;

}
