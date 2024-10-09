package com.NS_Soft_Tech.PracticeProject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="NS_WORLD_TABLE")
public class StudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String firstName;
    private String lastName;


    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    private String emailId;

    private String city;
    private String state;
    private String mobileNo;

    private String gender;

    @JsonFormat(pattern="yyyy-MM-dd")
    private String birthday;

    private String address;
    private String branch;

    public List<StudentCourses> getCourses() {
        return courses;
    }

    public void setCourses(List<StudentCourses> courses) {
        this.courses = courses;
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<StudentCourses> courses;

}