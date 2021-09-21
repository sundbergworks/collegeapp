package com.isaac.collegeapp.repo;

import com.isaac.collegeapp.model.ProfessorCourseDAO;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProfessorCourseRepository {


    // This is a class level variable because it was initialized outside of all the methods below
    String sticks = "stuff";

    public List<ProfessorCourseDAO> getProfessorCourseDAOList() {

        // this is a method level variable because it was initialized inside the method
        String sticks2 = "stuff";

        // System.out.println is a logging statement that prints out data in the console
        System.out.println("now in reo layer fetching data-4");

        // initializing two variables
        Connection conn = null;
        List<ProfessorCourseDAO> professorcourseDAOList = new ArrayList<>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeapp?user=root&password=password&useSSL=false");


            // Do something with the Connection
            String select = "SELECT * from professorcourse";
            PreparedStatement selectprofessorcourses = conn.prepareStatement(select);
            ResultSet resultSet = selectprofessorcourses.executeQuery();
            System.out.println (resultSet);
            professorcourseDAOList=parseResultSet(resultSet);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return professorcourseDAOList;
    }

    List<ProfessorCourseDAO> parseResultSet(ResultSet resultSet) {


        List<ProfessorCourseDAO> professorcourseDAOList=new ArrayList<>();

        try{
            while(resultSet.next()) {

                ProfessorCourseDAO professorcourseDAO=new ProfessorCourseDAO();
                professorcourseDAO.setProfessor_course_id(resultSet.getInt("professor_course_id"));
                professorcourseDAO.setProfessor_id(resultSet.getInt("professor_id"));
                professorcourseDAO.setCourse_id(resultSet.getInt("course_id"));
                professorcourseDAOList.add(professorcourseDAO);
            }

        } catch (SQLException ex ) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return professorcourseDAOList;
    }

}
