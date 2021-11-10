package com.isaac.collegeapp.model;

import java.util.List;

public class CourseListDAO {

    public List<CourseDAO> getCourseDAOList() {
        return courseDAOList;
    }

    public void setCourseDAOList(List<CourseDAO> courseDAOList) {
        this.courseDAOList = courseDAOList;
    }

    List<CourseDAO> courseDAOList;


}
