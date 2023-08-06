package com.example.demojpa_join.controller;

import com.example.demojpa_join.entity.Course;
import com.example.demojpa_join.entity.Teacher;
import com.example.demojpa_join.model.CourseOutputDTO;
import com.example.demojpa_join.model.TeacherDTO;
import com.example.demojpa_join.model.TeacherOutDTO;
import com.example.demojpa_join.repository.CourseRepository;
import com.example.demojpa_join.repository.TeacherRepository;
import com.example.demojpa_join.service.TestService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoJoin {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TestService testService;

    @GetMapping("/aop")
    public void view() {

        testService.testAOP();

    }
    @GetMapping("/view")
    public TeacherOutDTO view(@RequestParam Integer id) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

       Teacher teacher =  teacherRepository.findById(id).get();

       return modelMapper.map(teacher,TeacherOutDTO.class);

    }
    @GetMapping("/view2")
    public CourseOutputDTO view2(@RequestParam Integer id) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        Course course =  courseRepository.findById(id).get();

        CourseOutputDTO courseOutputDTO = modelMapper.map(course, CourseOutputDTO.class);

        return courseOutputDTO;

    }

    @GetMapping("/test")
    public void Test() {

/*        Course course = new Course();
        course.setName("TuTV1");

        courseRepository.save(course);

        Teacher teacher = new Teacher();

        teacher.setCourseId(1);
        teacher.setName("Teacher1");
        teacher.setStatus(1);

        teacherRepository.save(teacher);*/

        ModelMapper modelMapper = new ModelMapper();

        Course course = new Course();
        course.setName("TuTV2");


        List<Teacher> teachers = new ArrayList<>();




       // course.setTeachers(teachers);

        Course saved = courseRepository.save(course);

        Teacher teacher = new Teacher();
        //teacher.setCourseId(saved.getId());
        teacher.setCourse(saved);
        teacher.setName("Teacher2");
        teacher.setStatus(1);

        Teacher teacher2 = new Teacher();
        teacher2.setCourse(saved);
        teacher2.setName("Teacher22");
        teacher2.setStatus(1);


        teachers.add(teacher);
        teachers.add(teacher2);

        teacherRepository.saveAll(teachers);



    }


    @GetMapping("/test3")
    public void Test3() {

        Course course = new Course();
       // course.setId(16);
        course.setName("TuTV16_Course_Edit2222444");

//        Course course = courseRepository.findById(16).get();
//
//        course.setName("TuTV16_Course_New");

      //  Course saved = courseRepository.save(course);

        Teacher teacher = new Teacher();







        // course.setTeachers(teachers);



       // teacher.setId(31);
        teacher.setCourse(course);
        teacher.setName("Teacher123444455555");
        teacher.setStatus(1);

        //teacherRepository.save(teacher);
        course.getTeachers().add(teacher);

        Course saved = courseRepository.save(course);
        teacherRepository.save(teacher);
        return;



    }


    @GetMapping("/test4")
    public void Test4() {

        Course course = new Course();
        course.setName("TuTV19988");

      //  Course saved = courseRepository.save(course);

        Teacher teacher = new Teacher();

        teacher.setCourse(course);
        teacher.setName("Teacher9999");
        teacher.setStatus(1);

        Teacher teacher2 = new Teacher();

        teacher2.setCourse(course);
        teacher2.setName("Teacher3333");
        teacher2.setStatus(1);

        course.getTeachers().add(teacher);
        course.getTeachers().add(teacher2);



        // course.setTeachers(teachers);

        Course saved = courseRepository.save(course);
        //teacherRepository.save(teacher);

        return;



    }

    @PostMapping("/test2")
    public TeacherOutDTO Test2(@RequestBody TeacherDTO teacherDTO) {

/*        Course course = new Course();
        course.setName("TuTV1");

        courseRepository.save(course);

        Teacher teacher = new Teacher();

        teacher.setCourseId(1);
        teacher.setName("Teacher1");
        teacher.setStatus(1);

        teacherRepository.save(teacher);*/

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        Teacher newTeacher = modelMapper.map(teacherDTO,Teacher.class);


        Teacher savedTeacher = teacherRepository.save(newTeacher);

        return modelMapper.map(savedTeacher,TeacherOutDTO.class);



    }
}
