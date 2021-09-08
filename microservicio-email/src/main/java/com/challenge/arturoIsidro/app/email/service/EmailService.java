package com.challenge.arturoIsidro.app.email.service;

import java.util.List;

import com.challenge.arturoIsidro.app.email.dto.EmailDto;
import com.challenge.arturoIsidro.app.email.exceptions.EmailBadRequest;
import com.challenge.arturoIsidro.app.email.exceptions.EmailInternalError;
import com.challenge.arturoIsidro.app.email.exceptions.EmailNotFound;

public interface EmailService {
	
	EmailDto createEmail(EmailDto obj) throws EmailInternalError;

	List<EmailDto> listEmail();

	void deleteEmail(String email) throws EmailInternalError, EmailBadRequest;

	EmailDto findByEmail(String email) throws EmailNotFound;
}
