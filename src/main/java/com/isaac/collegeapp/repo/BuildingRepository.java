package com.isaac.collegeapp.repo;

import com.isaac.collegeapp.model.BuildingDAO;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BuildingRepository {



    public List<BuildingDAO> getBuildingDAOList() {

        System.out.println("now in reo layer fetching data-4");

        // initializing two variables
        Connection conn = null;
        List<BuildingDAO> buildingDAOList = new ArrayList<>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeapp?user=root&password=password&useSSL=false");


            // Do something with the Connection
            String select = "SELECT * from building";
            PreparedStatement selectbuildings = conn.prepareStatement(select);
            ResultSet resultSet = selectbuildings.executeQuery();
            System.out.println (resultSet);
            buildingDAOList=parseResultSet(resultSet);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return buildingDAOList;
    }

    List<BuildingDAO> parseResultSet(ResultSet resultSet) {

        List<BuildingDAO> buildingDAOList=new ArrayList<>();

        try{
            while(resultSet.next()) {

                BuildingDAO buildingDAO=new BuildingDAO();
                buildingDAO.setBuilding_id(resultSet.getInt("building_id"));
                buildingDAO.setBuilding_name(resultSet.getString("building_name"));
                buildingDAO.setDate_built(resultSet.getDate("date_built"));
                buildingDAO.setCoordinates(resultSet.getString("coordinates"));
                buildingDAO.setCapacity(resultSet.getInt("capacity"));
                buildingDAOList.add(buildingDAO);
            }

        } catch (SQLException ex ) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return buildingDAOList;
    }

}
