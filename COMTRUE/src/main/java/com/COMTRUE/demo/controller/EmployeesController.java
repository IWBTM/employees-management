package com.COMTRUE.demo.controller;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.COMTRUE.demo.service.EmployeesService;

@Controller
public class EmployeesController {

	@Autowired
	EmployeesService service;

	@GetMapping({ "/main", "" })
	private String main(@PageableDefault(size = 10, sort = "name", direction = Direction.ASC) Pageable pageable,
			@RequestParam(required = false) String whatSearch, @RequestParam(required = false) String q, Model model) {
		String myQ = q == null ? "" : q;
		if (myQ == "") {
			model.addAttribute("employeesList", service.findAll(pageable));
		} else {
			model.addAttribute("employeesList", service.findByCategorySearch(whatSearch, myQ, pageable));
		}
		model.addAttribute("q", myQ);
		return "main";
	}

	@GetMapping("/test")
	private String test() {
		String recipient = "ganggang00@kakao.com";

		final String user = "rnlduadl2000@naver.com";
		final String password = "rudalstm2";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject("반갑고 ~");
			message.setText("이해는 못 하겠지만, 조금은 쉽군.");

			Transport.send(message);
			System.out.println("성공 ~");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return "/";
	}
}
