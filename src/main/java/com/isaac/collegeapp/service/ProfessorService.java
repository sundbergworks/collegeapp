package com.isaac.collegeapp.service;

import com.isaac.collegeapp.businesslogic.ProfessorBL;
import com.isaac.collegeapp.model.ProfessorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfessorService {

    @Autowired
    ProfessorBL professorBL;

   public List<ProfessorDAO> getAllProfessorData() {

       System.out.println("service layer is now executing-2");


        return professorBL.getProfessorDAOList();
    }

}
