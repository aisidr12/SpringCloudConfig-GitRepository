package com.challenge.arturoIsidro.app.email.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import com.challenge.arturoIsidro.app.email.dto.EmailDto;
import com.challenge.arturoIsidro.app.email.entity.EmailEntity;

@Component
public class EmailMapper {
	
	public List<EmailDto>listEmails(List<EmailEntity>entityList){
		List<EmailDto>listEmails = new ArrayList<EmailDto>();
		for (EmailEntity emailEntity : ListUtils.emptyIfNull(entityList)) {
			EmailDto dtoEmail = new EmailDto();
			dtoEmail.setEmail(emailEntity.getEmail());
			dtoEmail.setNewsLetterActivated(emailEntity.getNewsLetterActivated());
			listEmails.add(dtoEmail);
		}	
		return listEmails;
	}
	
	public EmailEntity dtoToEntity(EmailDto dto) {
		EmailEntity entity = new EmailEntity();
		BeanUtils.copyProperties(dto, entity,getNullPropertyNames(dto));
		return entity;
	}
	
	public EmailDto entityToDto(EmailEntity entity) {
		EmailDto dto = new EmailDto();
		BeanUtils.copyProperties(entity, dto,getNullPropertyNames(entity));
		return dto;		
	}
	
	private static String[] getNullPropertyNames (Object source) {
	    final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    Set<String> emptyNames = new HashSet<String>();
	    for(java.beans.PropertyDescriptor pd : pds) {
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) emptyNames.add(pd.getName());
	    }

	    String[] result = new String[emptyNames.size()];
	    return emptyNames.toArray(result);
	}

}
