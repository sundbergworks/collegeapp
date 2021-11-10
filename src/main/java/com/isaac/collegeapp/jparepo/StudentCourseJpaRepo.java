package com.isaac.collegeapp.jparepo;

import com.isaac.collegeapp.model.StudentCourseDAO;
import com.isaac.collegeapp.model.StudentDAO;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentCourseJpaRepo extends JpaRepository<StudentCourseDAO, Integer> {




}
