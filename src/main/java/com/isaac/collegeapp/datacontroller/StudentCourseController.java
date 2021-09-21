package com.isaac.collegeapp.datacontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isaac.collegeapp.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/studentcourse")
@RestController
public class StudentCourseController {

    @Autowired
    StudentCourseService studentcourseService;

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/getAll")
    String getAllStudentCourses() throws JsonProcessingException {

      return objectMapper.writeValueAsString(studentcourseService.getAllStudentCourseData()) ;

    }


}
