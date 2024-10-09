package com.NS_Soft_Tech.PracticeProject.service;

import com.NS_Soft_Tech.PracticeProject.entity.StudentInfo;

import java.util.List;
import java.util.Optional;

public interface NSSoftTechRegFormService {
    public StudentInfo saveRecordOfNew(StudentInfo student);
    public List<StudentInfo> getAllDataOfStudent();
    public Optional<StudentInfo> getStudentByName(String firstName);

}
