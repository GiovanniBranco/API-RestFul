package org.serratec.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {

	@Autowired
	JavaMailSender javaMail;
	
	public String sendEmail(String para, String assunto, String texto) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("giovanni.branco@estudante.firjan.senai.br");
		mail.setTo(para);
		mail.setSubject(assunto);
		mail.setText(texto);
		
		javaMail.send(mail);
		return "Email enviado com sucesso!";
	}
}
