package com.isaac.collegeapp.viewcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isaac.collegeapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/studentView")
@Controller
public class StudentViewController {

    @Autowired
    StudentService studentService;

    ObjectMapper objectMapper = new ObjectMapper();



    @GetMapping("/viewStudents")
    String viewStudents(Model model){

        model.addAttribute("students", studentService.getAllStudentData());
        return "viewStudents.html";
    }




}
