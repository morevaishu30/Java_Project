package com.NS_Soft_Tech.PracticeProject.serviceimpl;

import com.NS_Soft_Tech.PracticeProject.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmailServiceImpl implements EmailService {
    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void sendSimpleEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("morevaishu219@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
        System.out.println("email saved sucessfully.....");

    }

    @Override
    public void sendRegistrEmails(String userEmail, String userName) {
        String userSubject="WELLCOME TO NSWORLD PLATFROM";
        String userBody ="Dear " +userName + ",\n\nThank yor for registring with NS_World";
        sendSimpleEmail(userEmail,userSubject,userBody);

    }

    @Override
    public void sendEmailToMultipleRecipients(List<String> toEmails, String subject, String body) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("morevaishu219@gmail.com");

        // Convert the list of emails into an array
        String[] recipientArray = toEmails.toArray(new String[0]);
        message.setTo(recipientArray);

        message.setSubject(subject);
        message.setText(body);

        javaMailSender.send(message);
        System.out.println("Email sent successfully to multiple recipients.");
    }


}
