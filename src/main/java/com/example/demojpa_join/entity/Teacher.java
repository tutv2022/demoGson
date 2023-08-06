package com.example.demojpa_join.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //@Column(name = "course_id")
    //private Integer courseId;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private Integer status;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn( name = "course_id")
    Course course;

}
