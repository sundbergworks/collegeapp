package com.isaac.collegeapp.model;

import java.sql.Date;

public class CourseDAO {

    // These are your data attributes for the model object
    // Step 1)
    Integer course_id;
    Integer room_id;
    String course_name;
    Integer creds;
    String description;


    // below here are the getters and setters


    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Integer getCreds() {
        return creds;
    }

    public void setCreds(Integer creds) {
        this.creds = creds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




   



}
