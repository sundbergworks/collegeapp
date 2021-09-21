package com.isaac.collegeapp.repo;

import com.isaac.collegeapp.model.RoomDAO;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoomRepository {



    public List<RoomDAO> getRoomDAOList() {

        System.out.println("now in reo layer fetching data-4");

        // initializing two variables
        Connection conn = null;
        List<RoomDAO> roomDAOList = new ArrayList<>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeapp?user=root&password=password&useSSL=false");


            // Do something with the Connection
            String select = "SELECT * from room";
            PreparedStatement selectrooms = conn.prepareStatement(select);
            ResultSet resultSet = selectrooms.executeQuery();
            System.out.println (resultSet);
            roomDAOList=parseResultSet(resultSet);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return roomDAOList;
    }

    List<RoomDAO> parseResultSet(ResultSet resultSet) {

        List<RoomDAO> roomDAOList=new ArrayList<>();

        try{
            while(resultSet.next()) {

                RoomDAO roomDAO=new RoomDAO();
                roomDAO.setRoom_id(resultSet.getInt("room_id"));
                roomDAO.setCapacity(resultSet.getString("capacity"));
                roomDAO.setRoom_number(resultSet.getInt("room_number"));
                roomDAO.setBuilding_id(resultSet.getInt("building_id"));
                roomDAOList.add(roomDAO);
            }

        } catch (SQLException ex ) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return roomDAOList;
    }

}
