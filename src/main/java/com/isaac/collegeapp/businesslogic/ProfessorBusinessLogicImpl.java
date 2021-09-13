package com.isaac.collegeapp.businesslogic;

import com.isaac.collegeapp.model.ProfessorDAO;
import com.isaac.collegeapp.repo.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfessorBusinessLogicImpl implements ProfessorBL{

    @Autowired
    ProfessorRepository professorRepository;


    @Override
    public List<ProfessorDAO> filterPhdProfessors(List<ProfessorDAO> professorDAOList) {
        return null;
    }

    @Override
    public List<ProfessorDAO> getProfessorDAOList() {
        return professorRepository.getProfessorDAOList();
    }

    @Override
    public ProfessorDAO getProfessorById(Integer professorid) {
        return null;
    }

    @Override
    public ProfessorDAO updateProfessor(ProfessorDAO professorDAO) {
        return null;
    }

    @Override
    public ProfessorDAO deleteProfessor(ProfessorDAO professorDAO) {
        return null;
    }

    @Override
    public ProfessorDAO createProfessor(ProfessorDAO professorDAO) {
        return null;
    }
}
