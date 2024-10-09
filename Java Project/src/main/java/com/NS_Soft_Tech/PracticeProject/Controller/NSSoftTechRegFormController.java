package com.NS_Soft_Tech.PracticeProject.Controller;

import com.NS_Soft_Tech.PracticeProject.entity.StudentInfo;
import com.NS_Soft_Tech.PracticeProject.service.EmailService;
import com.NS_Soft_Tech.PracticeProject.service.NSSoftTechRegFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Component
@RestController
@RequestMapping("/nssofttechregistration")

public class NSSoftTechRegFormController {

    @Autowired
    NSSoftTechRegFormService service;
    @Autowired
    EmailService emailService;


    @PostMapping("/savenewuser")
//    public StudentInfo saveNewUser(@RequestBody StudentInfo student){
//         NsWorldRegFormEntity ns = service.saveRecordOfNew(student);
//        //return service.saveRecordOfNew(student);
//
//        //  return ns;
//        //line no 17 and 19 are commented because code optimization
//    }
    public ResponseEntity<String>saveNewUser(@RequestBody StudentInfo student){
        StudentInfo ns=service.saveRecordOfNew(student);

        if (ns != null){
            emailService.sendSimpleEmail(student.getEmailId(),"String subject","String body");
            emailService.sendRegistrEmails(student.getEmailId(), student.getFirstName());
            return new ResponseEntity<>("Registration successful.", HttpStatus.OK);
        }
        return new ResponseEntity<>(" registration failed. " , HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/getalldata")
    public List<StudentInfo> getAllData(){

        return service.getAllDataOfStudent();
    }

@GetMapping("/student/{firstName}")
public ResponseEntity<StudentInfo> getStudentByName(@PathVariable String firstName) {
//
    Optional<StudentInfo> student = service.getStudentByName(firstName);

//
    return student.map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());

}
//
@PostMapping("/sendEmailsToAll")
public ResponseEntity<String> sendEmailsToAllStudents() {
    List<StudentInfo> students = service.getAllDataOfStudent();

    if (students.isEmpty()) {
        return new ResponseEntity<>("No students found.", HttpStatus.NO_CONTENT);
    }


    List<String> emailAddresses = students.stream()
            .map(StudentInfo::getEmailId)
            .collect(Collectors.toList());


    String subject = "Important Notification for Registered Students";
    String body = "Dear Students,\n\nThis is an important notification for all registered students at NS_World Platform.";


    emailService.sendEmailToMultipleRecipients(emailAddresses, subject, body);

    return new ResponseEntity<>("Emails sent to all registered students.", HttpStatus.OK);
}
}






