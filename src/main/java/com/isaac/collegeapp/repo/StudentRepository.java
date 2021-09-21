package com.isaac.collegeapp.repo;

import com.isaac.collegeapp.model.StudentDAO;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentRepository {



    public List<StudentDAO> getStudentDAOList() {

        System.out.println("now in reo layer fetching data-4");

        // initializing two variables
        Connection conn = null;
        List<StudentDAO> studentDAOList = new ArrayList<>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeapp?user=root&password=password&useSSL=false");


            // Do something with the Connection
            String select = "SELECT * from student";
            PreparedStatement selectstudents = conn.prepareStatement(select);
            ResultSet resultSet = selectstudents.executeQuery();
            System.out.println (resultSet);
            studentDAOList=parseResultSet(resultSet);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return studentDAOList;
    }

    List<StudentDAO> parseResultSet(ResultSet resultSet) {

        List<StudentDAO> studentDAOList=new ArrayList<>();

        try{
            while(resultSet.next()) {

                // on the right hand side is the mysql column name
                // on the left hand side is the java "Set" method
                StudentDAO studentDAO=new StudentDAO();
                studentDAO.setStudent_id(resultSet.getInt("student_id"));
                studentDAO.setStudent_name(resultSet.getString("student_name"));
                studentDAO.setBirthday(resultSet.getDate("birthday"));
                studentDAO.setStudent_id_number(resultSet.getInt("student_id_number"));
                studentDAOList.add(studentDAO);
            }

        } catch (SQLException ex ) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return studentDAOList;
    }

}
