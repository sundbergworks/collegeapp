package com.isaac.collegeapp.datacontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isaac.collegeapp.service.ProfessorCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/professorcourse")
@RestController
public class ProfessorCourseController {

    @Autowired
    ProfessorCourseService professorcourseService;

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/getAll")
    String getAllProfessorCourses() throws JsonProcessingException {

      return objectMapper.writeValueAsString(professorcourseService.getAllProfessorCourseData()) ;

    }


}
