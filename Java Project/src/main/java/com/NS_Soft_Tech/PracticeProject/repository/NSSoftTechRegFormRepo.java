package com.NS_Soft_Tech.PracticeProject.repository;

import com.NS_Soft_Tech.PracticeProject.entity.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Repository
@Component
public interface NSSoftTechRegFormRepo extends JpaRepository<StudentInfo,Long> {
   // Optional<StudentInfo>getStudentByName(String firstName);
    Optional<StudentInfo> findByfirstName(String firstName);
}
