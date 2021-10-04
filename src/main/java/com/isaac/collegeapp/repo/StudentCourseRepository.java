package com.isaac.collegeapp.repo;

import com.isaac.collegeapp.model.StudentCourseDAO;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentCourseRepository {



    public List<StudentCourseDAO> getStudentCourseDAOList() {

        System.out.println("now in reo layer fetching data-4");

        // initializing two variables
        Connection conn = null;
        List<StudentCourseDAO> studentcourseDAOList = new ArrayList<>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeapp?user=root&password=password&useSSL=false");


            // Do something with the Connection
            String select = "SELECT * from studentcourse";
            PreparedStatement selectstudentcourses = conn.prepareStatement(select);
            ResultSet resultSet = selectstudentcourses.executeQuery();
            System.out.println (resultSet);
            studentcourseDAOList=parseResultSet(resultSet);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return studentcourseDAOList;
    }

    List<StudentCourseDAO> parseResultSet(ResultSet resultSet) {

        List<StudentCourseDAO> studentcourseDAOList=new ArrayList<>();

        try{
            while(resultSet.next()) {

                StudentCourseDAO studentcourseDAO=new StudentCourseDAO();
                studentcourseDAO.setStudent_course_id(resultSet.getInt("student_course_id"));
                studentcourseDAO.setCourse_id(resultSet.getInt("course_id"));
                studentcourseDAO.setStudent_id(resultSet.getInt("student_id"));
                studentcourseDAOList.add(studentcourseDAO);
            }
        } catch (SQLException ex ) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return studentcourseDAOList;
    }

}