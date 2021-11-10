package com.isaac.collegeapp.jparepo;

import com.isaac.collegeapp.model.CourseDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CourseJpaRepo extends JpaRepository<CourseDAO, Integer> {

    CourseDAO findByCourseId(int courseid);
    



}
