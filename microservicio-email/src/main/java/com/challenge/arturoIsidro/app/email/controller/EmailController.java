package com.challenge.arturoIsidro.app.email.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.arturoIsidro.app.email.dto.EmailDto;
import com.challenge.arturoIsidro.app.email.exceptions.EmailBadRequest;
import com.challenge.arturoIsidro.app.email.exceptions.EmailNotFound;
import com.challenge.arturoIsidro.app.email.service.EmailService;
import com.challenge.arturoIsidro.app.email.utils.EmailErrors;
import com.challenge.arturoIsidro.app.email.view.EmailView;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@GetMapping("/listEmail")
	public ResponseEntity<EmailView>listEmail(){
		EmailView view= new EmailView();		
		List<EmailDto>listado =	emailService.listEmail();
		view.setCodError("OK");
		view.setListEmails(listado);
		return ResponseEntity.ok().body(view);
	}
	
	
	@GetMapping("/findEmail/{email}/")
	public ResponseEntity<EmailView>findEmail(@PathVariable("email")String email){
		EmailView view= new EmailView();
			try {				
				if(org.apache.commons.lang.StringUtils.isEmpty(email))throw new EmailBadRequest(EmailErrors.Email_003.getCode(), EmailErrors.Email_003.getMsg());
				EmailDto dtoMail =	emailService.findByEmail(email);
				view.getListEmails().add(dtoMail);
				view.setCodError(EmailErrors.correct.getCode());
			} catch (EmailNotFound e) {			
				view.setCodError(e.getCodError());
				view.setMsgError(e.getMsgError());
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(view);
			} catch (EmailBadRequest e) {
				view.setCodError(e.getCodError());
				view.setMsgError(e.getMsgError());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(view);
			}
			return ResponseEntity.ok().body(view);
	}
	
	
	
	
}
