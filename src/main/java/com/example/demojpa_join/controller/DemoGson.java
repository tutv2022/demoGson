package com.example.demojpa_join.controller;

import com.example.demojpa_join.entity.Course;
import com.example.demojpa_join.model.CourseOutputDTO;
import com.example.demojpa_join.repository.CourseRepository;
import com.example.demojpa_join.repository.TeacherRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.Map;

@RestController
public class DemoGson {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TeacherRepository teacherRepository;


    @GetMapping("/diff")
    public void testDiff() throws JsonProcessingException {


        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        Course course15 =  courseRepository.findById(15).get();
        Course course16 =  courseRepository.findById(16).get();


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        CourseOutputDTO courseOutput15DTO = modelMapper.map(course15, CourseOutputDTO.class);
        CourseOutputDTO courseOutput16DTO = modelMapper.map(course16, CourseOutputDTO.class);


        String json15 = mapper.writeValueAsString(courseOutput15DTO);

        String json16 = mapper.writeValueAsString(courseOutput16DTO);

        Gson g = new Gson();
        Type mapType = new TypeToken<Map<String, Object>>(){}.getType();
        Map<String, Object> firstMap = g.fromJson(json15, mapType);
        Map<String, Object> secondMap = g.fromJson(json16, mapType);

        MapDifference<String, Object> difference = Maps.difference(firstMap, secondMap);
        System.out.println(difference);

    }
}
