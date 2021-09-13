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

        return professorBL.getProfessorDAOList();
    }

}
