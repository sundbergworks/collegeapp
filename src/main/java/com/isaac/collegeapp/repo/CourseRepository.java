package com.isaac.collegeapp.repo;

import com.isaac.collegeapp.model.CourseDAO;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CourseRepository {



    public List<CourseDAO> getCourseDAOList() {

        System.out.println("now in reo layer fetching data-4");

        // initializing two variables
        Connection conn = null;
        List<CourseDAO> courseDAOList = new ArrayList<>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeapp?user=root&password=password&useSSL=false");


            // Do something with the Connection
            String select = "SELECT * from course";
            PreparedStatement selectcourses = conn.prepareStatement(select);
            ResultSet resultSet = selectcourses.executeQuery();
            System.out.println (resultSet);
            courseDAOList=parseResultSet(resultSet);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return courseDAOList;
    }

    List<CourseDAO> parseResultSet(ResultSet resultSet) {

        List<CourseDAO> courseDAOList=new ArrayList<>();

        try{
            while(resultSet.next()) {

                CourseDAO courseDAO=new CourseDAO();
                courseDAO.setCourse_id(resultSet.getInt("course_id"));
                courseDAO.setCourse_name(resultSet.getString("course_name"));
                courseDAO.setRoom_id(resultSet.getInt("room_id"));
                courseDAO.setCreds(resultSet.getInt("creds"));
                courseDAOList.add(courseDAO);
            }



        } catch (SQLException ex ) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return courseDAOList;
    }

}

