package com.example.demojpa_join.repository;

import com.example.demojpa_join.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}