package com.challenge.arturoIsidro.app.email.exceptions;

public class EmailBadRequest extends Exception {
	private static final long serialVersionUID = 8305257127107845892L;

	private String codError;
	private String msgError;
		
	public EmailBadRequest(String codError, String msgError) {
		this.codError = codError;
		this.msgError = msgError;
	}
	
	public String getCodError() {
		return codError;
	}
	public void setCodError(String codError) {
		this.codError = codError;
	}
	public String getMsgError() {
		return msgError;
	}
	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}
	
	
	
}
