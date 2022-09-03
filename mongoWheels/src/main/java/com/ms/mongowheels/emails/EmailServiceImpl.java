package com.ms.mongowheels.emails;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class EmailServiceImpl {

	@Autowired 
	private JavaMailSender emailSender;
	
	public void sendSimpleMessage(String to, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		emailSender.send(message);
	}
	
	@Autowired
	private TemplateEngine templateEngine;
	
	public void sentMailWithThymeleaf(String to, String subject, String name, String messageBody, String footer)
		throws MessagingException { 
			
		//stores the attributes to be replaced in the HTML page
		//import from thymeleaf context
		final Context ctx = new Context();
		ctx.setVariable("name", name);
		ctx.setVariable("message", messageBody);
		ctx.setVariable("footer", footer);
		
		//adding the context variables into our html page
		final String htmlContext = this.templateEngine.process("emailTemplate.html", ctx);
		
		final MimeMessage mimeMessage = this.emailSender.createMimeMessage();
		final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		
		//Construct the parts of our email
		message.setTo(to);
		message.setSubject(subject);
		message.setText(htmlContext, true); //true will process as HTML
		
		this.emailSender.send(mimeMessage);
		}
	}
