package com.isaac.collegeapp.repo;

import com.isaac.collegeapp.model.ProfessorDAO;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProfessorRepository {



    public List<ProfessorDAO> getProfessorDAOList() {

        System.out.println("now in reo layer fetching data-4");

        // initializing two variables
        Connection conn = null;
        List<ProfessorDAO> professorDAOList = new ArrayList<>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeapp?user=root&password=password&useSSL=false");


            // Do something with the Connection
            String select = "SELECT * from professor";
            PreparedStatement selectprofessors = conn.prepareStatement(select);
            ResultSet resultSet = selectprofessors.executeQuery();
            System.out.println (resultSet);
            professorDAOList=parseResultSet(resultSet);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return professorDAOList;
    }

    List<ProfessorDAO> parseResultSet(ResultSet resultSet) {

        List<ProfessorDAO> professorDAOList=new ArrayList<>();

        try{
            while(resultSet.next()) {

                ProfessorDAO professorDAO=new ProfessorDAO();
                professorDAO.setProfessor_id(resultSet.getInt("professor_id"));
                professorDAO.setProfessor_name(resultSet.getString("professor_name"));
                professorDAO.setHire_date(resultSet.getDate("hire_date"));
                professorDAO.setHas_phd(resultSet.getInt("has_phd"));
                professorDAOList.add(professorDAO);
            }

        } catch (SQLException ex ) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return professorDAOList;
    }

}
