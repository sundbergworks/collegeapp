package com.isaac.collegeapp.repo;

import com.isaac.collegeapp.model.BookDAO;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepository {



    public List<BookDAO> getBookDAOList() {

        System.out.println("now in reo layer fetching data-4");

        // initializing two variables
        Connection conn = null;
        List<BookDAO> bookDAOList = new ArrayList<>();

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeapp?user=root&password=password&useSSL=false");


            // Do something with the Connection
            String select = "SELECT * from book";
            PreparedStatement selectbooks = conn.prepareStatement(select);
            ResultSet resultSet = selectbooks.executeQuery();
            System.out.println (resultSet);
            bookDAOList=parseResultSet(resultSet);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return bookDAOList;
    }

    List<BookDAO> parseResultSet(ResultSet resultSet) {

        List<BookDAO> bookDAOList=new ArrayList<>();

        try{
            while(resultSet.next()) {

                BookDAO bookDAO=new BookDAO();
                bookDAO.setBook_id(resultSet.getInt("book_id"));
                bookDAO.setBook_name(resultSet.getString("book_name"));
                bookDAO.setEdition(resultSet.getString("edition"));
                bookDAO.setCourse_id(resultSet.getString("course_id"));
                bookDAOList.add(bookDAO);
            }


        } catch (SQLException ex ) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return bookDAOList;
    }

}
