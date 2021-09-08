package com.challenge.arturoIsidro.app.email.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="email")
public class EmailEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="email")
	private String email;
	@Column(name="newLetterActivated")
	private String newsLetterActivated;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNewsLetterActivated() {
		return newsLetterActivated;
	}
	public void setNewsLetterActivated(String newsLetterActivated) {
		this.newsLetterActivated = newsLetterActivated;
	}
	
	
	

}
