package com.challenge.arturoIsidro.app.email.utils;

public class Pair<F,S> {

	private F code;
	private S msg;
	
	public Pair(F code,S msg) {
		this.code=code;
		this.msg=msg;
	}

	public F getCode() {
		return code;
	}

	public void setCode(F code) {
		this.code = code;
	}

	public S getMsg() {
		return msg;
	}

	public void setMsg(S msg) {
		this.msg = msg;
	}
	
	
}
