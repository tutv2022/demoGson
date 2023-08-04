package com.example.demojpa_join.repository;

import com.example.demojpa_join.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}