package com.NS_Soft_Tech.PracticeProject.repository;

import com.NS_Soft_Tech.PracticeProject.entity.StudentCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component

public interface NSSoftTechRegFromCoursesRepo extends JpaRepository<StudentCourses,Long> {
}
