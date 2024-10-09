package com.NS_Soft_Tech.PracticeProject.service;

import java.util.List;

public interface EmailService {
    public void sendSimpleEmail(String toEmail,String subject,String body);
    public void sendRegistrEmails(String userEmail, String userName);
    // New method to send an email to multiple recipients
    void sendEmailToMultipleRecipients(List<String> toEmails, String subject, String body);

}
