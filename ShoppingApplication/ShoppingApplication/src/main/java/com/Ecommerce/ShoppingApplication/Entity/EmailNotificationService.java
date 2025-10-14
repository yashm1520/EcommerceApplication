package com.Ecommerce.ShoppingApplication.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailNotificationService implements NotificationService {

	
	 @Autowired
	  private JavaMailSender mailSender;
	@Override
	public void sendOrderConfirmation(String toEmail, String subject, String body) {
		// TODO Auto-generated method stub
		  SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("yashm1520@gmail.com");
	        message.setTo(toEmail);
	        message.setSubject(subject);
	        message.setText(body);
	        mailSender.send(message);
	}

}
