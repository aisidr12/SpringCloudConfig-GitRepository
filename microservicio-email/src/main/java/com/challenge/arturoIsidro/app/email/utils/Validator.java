package com.challenge.arturoIsidro.app.email.utils;

public class Validator {

	public static boolean validatorMail(String mail) {
		if(mail.isEmpty() || mail == null) {
			return false;
		}
		if(mail.contains("@")) {
			return true;
		}else {
			return false;
		}
	}
}
