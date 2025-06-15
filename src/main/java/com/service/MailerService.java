package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailerService {

	@Autowired
	JavaMailSender mailSender;
	
	public void sendWelcomeMail(String email) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("tejasshah2k19@gmail.com");
		message.setTo(email);
		message.setSubject("Welcome email"); 
		message.setText("Welcome to alibaba , we are happy to server you");
		
		mailSender.send(message);
		
	}
}
