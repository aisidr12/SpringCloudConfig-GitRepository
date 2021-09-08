package com.challenge.arturoIsidro.app.email.view;

import java.util.ArrayList;
import java.util.List;

import com.challenge.arturoIsidro.app.email.dto.EmailDto;

public class EmailView extends InfoResultBase{
	
	private List<EmailDto>listEmails= new ArrayList<EmailDto>();

	public List<EmailDto> getListEmails() {
		return listEmails;
	}
	public void setListEmails(List<EmailDto> listEmails) {
		this.listEmails = listEmails;
	}
	
	
		

}
