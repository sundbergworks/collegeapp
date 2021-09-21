package com.isaac.collegeapp.businesslogic;

import com.isaac.collegeapp.model.CourseDAO;
import com.isaac.collegeapp.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseBusinessLogicImpl implements CourseBL{

    @Autowired
    CourseRepository courseRepository;


    @Override
    public List<CourseDAO> filterPhdCourses(List<CourseDAO> courseDAOList) {
        return null;
    }

    @Override
    public List<CourseDAO> getCourseDAOList() {
        System.out.println("business logic imp is executing -3");

        return courseRepository.getCourseDAOList();
    }

    @Override
    public CourseDAO getCourseById(Integer courseid) {
        return null;
    }

    @Override
    public CourseDAO updateCourse(CourseDAO courseDAO) {
        return null;
    }

    @Override
    public CourseDAO deleteCourse(CourseDAO courseDAO) {
        return null;
    }

    @Override
    public CourseDAO createCourse(CourseDAO courseDAO) {
        return null;
    }
}
