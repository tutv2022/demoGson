package com.example.demojpa_join.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="course")
    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn( name = "course_id")
    private List<Teacher> teachers = new ArrayList<>();

}
