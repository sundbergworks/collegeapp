package com.isaac.collegeapp.model;

import javax.persistence.*;


@Entity
@Table(name="course")
public class CourseDAO {




    // These are your data attributes for the model object
    // Step 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id")
    Integer courseId;
    @Column(name="room_id")
    Integer roomId;
    @Column(name="course_name")
    String courseName;
    Integer creds;
    @Column(name="course_id_desc")
    String courseIdDesc;


    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCreds() {
        return creds;
    }

    public void setCreds(Integer creds) {
        this.creds = creds;
    }

    public String getCourseIdDesc() {
        return courseIdDesc;
    }

    public void setCourseIdDesc(String courseIdDesc) {
        this.courseIdDesc = courseIdDesc;
    }



}
