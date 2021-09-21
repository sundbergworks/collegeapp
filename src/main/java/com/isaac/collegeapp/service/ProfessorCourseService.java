package com.isaac.collegeapp.service;

import com.isaac.collegeapp.businesslogic.ProfessorCourseBL;
import com.isaac.collegeapp.model.ProfessorCourseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfessorCourseService {

    @Autowired
    ProfessorCourseBL professorcourseBL;

   public List<ProfessorCourseDAO> getAllProfessorCourseData() {

       System.out.println("service layer is now executing-2");


        return professorcourseBL.getProfessorCourseDAOList();
    }

}
