package com.isaac.collegeapp.viewcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isaac.collegeapp.jparepo.CourseJpaRepo;
import com.isaac.collegeapp.jparepo.StudentCourseJpaRepo;
import com.isaac.collegeapp.jparepo.StudentJpaRepo;
import com.isaac.collegeapp.model.CourseDAO;
import com.isaac.collegeapp.model.StudentCourseDAO;
import com.isaac.collegeapp.model.StudentDAO;
import com.isaac.collegeapp.service.CourseService;
import com.isaac.collegeapp.util.ControllerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/courseView")
@Controller
public class CourseViewController {

    @Autowired
    CourseService courseService;

    @Autowired
    ControllerHelper controllerHelper;

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    StudentCourseJpaRepo studentCourseJpaRepo;

    @Autowired
    StudentJpaRepo studentJpaRepo;

    @Autowired
    CourseJpaRepo courseJpaRepo;




    ObjectMapper objectMapper = new ObjectMapper();



    @GetMapping("/viewCourses")
    String viewCourses(Model model){

        model.addAttribute("courses", courseService.getAllCourseData());
        return "viewCourses.html";
    }

    @GetMapping("/viewRealEstate")
    String viewRealEstate(){

        return "viewRealEstate.html";
    }

    @GetMapping("/viewCourseSignUp")
    String viewCourseSignUp(Model model){

        controllerHelper.checkForLoggedInStudent(model, httpServletRequest);

        model.addAttribute("courses", courseService.getAllCourseData()); // this is the list of available courses

        model.addAttribute("studentscourses", new ArrayList<CourseDAO>()); // this is the list of courses the student is signed up for

        model.addAttribute("course", new CourseDAO()); // this is the course from the dropdown select box



        return "course-Signup.html";
    }

    @PostMapping("/submitCourse")
    String submitCourse(@ModelAttribute( "course" ) CourseDAO course, Model model){

        // get cookie to get students id
       String studentid= httpServletRequest.getCookies()[0].getValue();

       // run query on student table to get the whole student
       StudentDAO studentDAO = studentJpaRepo.findByStudentIDNumber(Integer.valueOf(studentid));

        // get course id
        int course_id = course.getCourseId();

        // create student course object and hydrate with above ( put data inside object)

        StudentCourseDAO studentCourseDAO = new StudentCourseDAO();
        studentCourseDAO.setStudentCourseId(0);
        studentCourseDAO.setCourseId(course_id);
        studentCourseDAO.setStudentId(studentDAO.getStudentID());

        // save new student course object into database
        studentCourseJpaRepo.save(studentCourseDAO);

        // run query on student course table to find get all entries for student id



        // loop through course list abd make new list of only the studentscourses and bind to student courses object


        model.addAttribute("studentscourses", courseService.getCoursesForStudent(studentDAO));
        model.addAttribute("courses", courseService.getAllCourseData());
        model.addAttribute("course", new CourseDAO());







        return "course-Signup.html";

    }




}
