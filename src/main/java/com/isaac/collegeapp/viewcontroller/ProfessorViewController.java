package com.isaac.collegeapp.viewcontroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isaac.collegeapp.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/professorView")
@Controller
public class ProfessorViewController {

    @Autowired
    ProfessorService professorService;

    ObjectMapper objectMapper = new ObjectMapper();



    @GetMapping("/viewProfessors")
    String viewProfessors(Model model){

        model.addAttribute("professors", professorService.getAllProfessorData());
        return "viewProfessors.html";
    }




}
