package com.example.demojpa_join.service;

import com.example.demojpa_join.aspect.CustomLogger;
import com.example.demojpa_join.entity.Course;
import com.example.demojpa_join.entity.Teacher;
import com.example.demojpa_join.model.CourseOutputDTO;
import com.example.demojpa_join.model.TeacherOutDTO;
import com.example.demojpa_join.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService {

    @Autowired
    CourseRepository courseRepository;

    @CustomLogger
    public CourseOutputDTO testAOP(){
        log.warn("Test AOP");
        //throw  new RuntimeException("Test Error");
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        Course course =  courseRepository.findById(16).get();

        return modelMapper.map(course, CourseOutputDTO.class);
    }
}
