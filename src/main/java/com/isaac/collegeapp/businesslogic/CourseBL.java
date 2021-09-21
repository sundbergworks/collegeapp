package com.isaac.collegeapp.businesslogic;

import com.isaac.collegeapp.model.CourseDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CourseBL {

   public List<CourseDAO> filterPhdCourses (List<CourseDAO> courseDAOList);
   public List<CourseDAO> getCourseDAOList ();
   public CourseDAO getCourseById(Integer courseid);
   public  CourseDAO updateCourse(CourseDAO courseDAO);
   public  CourseDAO deleteCourse(CourseDAO courseDAO);
   public CourseDAO createCourse(CourseDAO courseDAO);

}
