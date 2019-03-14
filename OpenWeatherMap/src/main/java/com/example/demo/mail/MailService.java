package com.example.demo.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	MailBodyBuilder mailBodyBuilder;
	
	
	public void sendEmail(String recipient,String body ) {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
	        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
	        messageHelper.setFrom("keopskv@gmail.com");
	        messageHelper.setTo(recipient);
	        messageHelper.setSubject("Weather Forecast");
	        String content = mailBodyBuilder.buildBody(body);
	        messageHelper.setText(content,true);
	};
		try {
			mailSender.send(messagePreparator);
		}
		catch(MailException me) {
			me.printStackTrace();
		}
	}
	
}
