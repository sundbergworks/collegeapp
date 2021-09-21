package com.isaac.collegeapp.businesslogic;

import com.isaac.collegeapp.model.StudentDAO;
import com.isaac.collegeapp.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentBusinessLogicImpl implements StudentBL{

    @Autowired
    StudentRepository studentRepository;


    @Override
    public List<StudentDAO> filterPhdStudents(List<StudentDAO> studentDAOList) {
        return null;
    }

    @Override
    public List<StudentDAO> getStudentDAOList() {
        System.out.println("business logic imp is executing -3");

        return studentRepository.getStudentDAOList();
    }

    @Override
    public StudentDAO getStudentById(Integer studentid) {
        return null;
    }

    @Override
    public StudentDAO updateStudent(StudentDAO studentDAO) {
        return null;
    }

    @Override
    public StudentDAO deleteStudent(StudentDAO studentDAO) {
        return null;
    }

    @Override
    public StudentDAO createStudent(StudentDAO studentDAO) {
        return null;
    }
}
