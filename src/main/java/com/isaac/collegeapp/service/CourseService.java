package com.isaac.collegeapp.service;

import com.isaac.collegeapp.businesslogic.CourseBL;
import com.isaac.collegeapp.jparepo.CourseJpaRepo;
import com.isaac.collegeapp.jparepo.StudentCourseJpaRepo;
import com.isaac.collegeapp.model.CourseDAO;
import com.isaac.collegeapp.model.CourseDAO;
import com.isaac.collegeapp.model.StudentCourseDAO;
import com.isaac.collegeapp.model.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseService {

    @Autowired
    CourseBL courseBL;

    @Autowired
    StudentCourseJpaRepo studentCourseJpaRepo;

    @Autowired
    CourseJpaRepo courseJpaRepo;


   public List<CourseDAO> getAllCourseData() {

       System.out.println("service layer is now executing-2");


        return courseBL.getCourseDAOList();
    }

    public String createCourse(CourseDAO courseDAO) {

        System.out.println("service layer is now executing-2");


        return courseBL.createCourse(courseDAO);
    }

    public String updateCourse(CourseDAO courseDAO) {

        System.out.println("service layer is now executing-2");


        return courseBL.updateCourse(courseDAO);
    }

    public String deleteCourse(CourseDAO courseDAO) {

        System.out.println("service layer is now executing-2");


        return courseBL.deleteCourse(courseDAO);
    }

    public List<CourseDAO> getCoursesForStudent(StudentDAO studentDAO) {

        List<StudentCourseDAO> studentCourseDAOList = studentCourseJpaRepo.findAllByStudentId(studentDAO.getStudentID());

        // get all courses from database
        List<CourseDAO> courseDAOList = new ArrayList<>();
        for (StudentCourseDAO item: studentCourseDAOList) {
            CourseDAO courseDAO =courseJpaRepo.findByCourseId(item.getCourseId());
            courseDAOList.add(courseDAO);


        }



        return courseDAOList;
    }
}
