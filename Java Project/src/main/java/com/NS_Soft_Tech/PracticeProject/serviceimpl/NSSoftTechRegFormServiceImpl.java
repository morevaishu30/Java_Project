package com.NS_Soft_Tech.PracticeProject.serviceimpl;

import com.NS_Soft_Tech.PracticeProject.entity.StudentInfo;
import com.NS_Soft_Tech.PracticeProject.repository.NSSoftTechRegFormRepo;
import com.NS_Soft_Tech.PracticeProject.service.NSSoftTechRegFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//@Service
@Component
public class NSSoftTechRegFormServiceImpl implements NSSoftTechRegFormService {

    @Autowired
    NSSoftTechRegFormRepo repo;
//    public StudentInfo saveRecordOfNew(StudentInfo student) {
//        return repo.save(student);
//    }
public StudentInfo saveRecordOfNew(StudentInfo student) {
    student.getCourses().forEach(course->course.setStudent(student));
    return repo.save(student);
}

    @Override
    public List<StudentInfo> getAllDataOfStudent() {
        return repo.findAll();
    }


    @Override
    public Optional<StudentInfo> getStudentByName(String firstName) {
        return repo.findByfirstName(firstName);
    }


}
