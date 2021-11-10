package com.isaac.collegeapp.model;


import javax.persistence.*;

@Entity
@Table(name="studentcourse")
public class StudentCourseDAO {


    // These are your data attributes for the model object
    // Step 1)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_course_id")
    Integer studentCourseId;

    @Column(name="student_id")
    Integer studentId;

    @Column(name="course_id")
    Integer courseId;

    // below here are the getters and setters



    public Integer getStudentCourseId() {
        return studentCourseId;
    }

    public void setStudentCourseId(Integer studentCourseId) {
        this.studentCourseId = studentCourseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }


}
