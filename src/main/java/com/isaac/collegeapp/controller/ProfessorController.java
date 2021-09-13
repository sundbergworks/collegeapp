package com.isaac.collegeapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isaac.collegeapp.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/professor")
@RestController
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/getAll")
    String getAllProfessors() throws JsonProcessingException {

      return objectMapper.writeValueAsString(professorService.getAllProfessorData()) ;

    }


}
