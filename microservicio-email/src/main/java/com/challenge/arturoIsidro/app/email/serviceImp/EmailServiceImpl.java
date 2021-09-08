package com.challenge.arturoIsidro.app.email.serviceImp;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.arturoIsidro.app.email.dto.EmailDto;
import com.challenge.arturoIsidro.app.email.entity.EmailEntity;
import com.challenge.arturoIsidro.app.email.exceptions.EmailBadRequest;
import com.challenge.arturoIsidro.app.email.exceptions.EmailInternalError;
import com.challenge.arturoIsidro.app.email.exceptions.EmailNotFound;
import com.challenge.arturoIsidro.app.email.mapper.EmailMapper;
import com.challenge.arturoIsidro.app.email.repository.EmailRepository;
import com.challenge.arturoIsidro.app.email.service.EmailService;
import com.challenge.arturoIsidro.app.email.utils.EmailErrors;


@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailRepository emailDAO;

	@Autowired
	private EmailMapper mapper;

	@Override
	public EmailDto createEmail(EmailDto dto) {
		if (dto != null) {
			EmailEntity entidad = mapper.dtoToEntity(dto);
			emailDAO.save(entidad);
		}
		return dto;
	}

	@Override
	public List<EmailDto> listEmail() {
		return mapper.listEmails(emailDAO.findAll());
	}

	@Override
	public void deleteEmail(String email) throws EmailInternalError, EmailBadRequest {
		if (StringUtils.isEmpty(email))
			throw new EmailBadRequest(EmailErrors.Email_003.getCode(),EmailErrors.Email_003.getMsg());
		try {
			Optional<EmailEntity>optional = emailDAO.findByemail(email);
			if(optional.isPresent()) {
				emailDAO.delete(optional.get());
			}else {
				throw new EmailNotFound(EmailErrors.Email_002.getCode(),EmailErrors.Email_002.getMsg());

			}
		
		} catch (Exception e) {
			throw new EmailInternalError(EmailErrors.Email_002.getCode(),EmailErrors.Email_002.getMsg());
		}
	}

	@Override
	public EmailDto findByEmail(String email) throws EmailNotFound {
		Optional<EmailEntity> entity = emailDAO.findByemail(email);
		if (entity.isPresent()) {
			return mapper.entityToDto(entity.get());
		} else {
			throw new EmailNotFound(EmailErrors.Email_001.getCode(),EmailErrors.Email_001.getMsg());
		}
	}

}
