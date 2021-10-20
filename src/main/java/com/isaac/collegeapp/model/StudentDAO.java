package com.isaac.collegeapp.model;


import java.sql.Date;

public class StudentDAO {

    // These are your data attributes for the model object
    // Step 1)
    Integer student_id;
    String student_name;

    Date birthday;
    Integer student_id_number;

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getStudent_id_number() {
        return student_id_number;
    }

    public void setStudent_id_number(Integer student_id_number) {
        this.student_id_number = student_id_number;
    }





}
