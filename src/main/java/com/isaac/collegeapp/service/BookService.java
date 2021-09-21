package com.isaac.collegeapp.service;

import com.isaac.collegeapp.businesslogic.BookBL;
import com.isaac.collegeapp.model.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {

    @Autowired
    BookBL bookBL;

   public List<BookDAO> getAllBookData() {

       System.out.println("service layer is now executing-2");


        return bookBL.getBookDAOList();
    }

}
