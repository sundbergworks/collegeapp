package com.isaac.collegeapp.repo;

import com.isaac.collegeapp.model.CourseDAO;
import com.isaac.collegeapp.model.RoomDAO;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CourseRepository {

    public String createCourse(CourseDAO courseDAO){
        Connection conn = null;
        int existingMaxPrimaryKey = 0;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeapp?user=root&password=password&useSSL=false");



            // execute sql query to get the max id so we can increment primary key
            String getprimarykeymax = "SELECT MAX(COURSE_ID) as course_id_max FROM COURSE;";
            PreparedStatement getPrimaryKeyStatement = conn.prepareStatement(getprimarykeymax);
            ResultSet primaryKeyResult = getPrimaryKeyStatement.executeQuery();
            while(primaryKeyResult.next()){
                existingMaxPrimaryKey = primaryKeyResult.getInt("course_id_max");
            }




            String sql = "INSERT INTO Course(course_id, room_id,course_name,creds,course_id_desc) VALUES (?, ?, ?, ?)";
            // INSERT INTO course (course_id, room_id,course_name, creds,course_id_desc) VALUES (1, 7,'math',4,'Mathematics');

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, existingMaxPrimaryKey +1); // this probably gonna throw a null pointer becuase on create statements we dont use a PRIMARY KEY
            statement.setInt(2, courseDAO.getRoom_id());
            statement.setString(3, courseDAO.getCourse_name());
            statement.setInt(4, courseDAO.getCreds());
            statement.setString(4, courseDAO.getCourse_id_desc());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new course was inserted successfully!");
            }


        } catch (Exception exception){

            System.out.println("caught exception: "+exception.getMessage());
        }


        return "success";

    }

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

