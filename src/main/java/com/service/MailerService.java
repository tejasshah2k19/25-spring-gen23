package com.service;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailerService {

	@Autowired
	JavaMailSender mailSender;

	public void sendWelcomeMailOld(String email) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("tejasshah2k19@gmail.com");
		message.setTo(email);
		message.setSubject("Welcome email");
		message.setText("Welcome to alibaba , we are happy to server you");

		mailSender.send(message);

	}

	public void sendWelcomeMail(String email,String firstName) {

		MimeMessage message = mailSender.createMimeMessage();
		try {
			ClassPathResource resource = new ClassPathResource("templates/WelcomeMail.html");
			
			String htmlData = resource.getContentAsString(Charset.defaultCharset()); 
			
			 htmlData = htmlData.replace("{{name}}", firstName);
			
			
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom("tejasshah2k19@gmail.com");
			helper.setTo(email);
			helper.setSubject("Welcome email");
			helper.setText(htmlData, true);
			mailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
