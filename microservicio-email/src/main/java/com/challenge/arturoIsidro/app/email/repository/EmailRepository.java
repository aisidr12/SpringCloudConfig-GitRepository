package com.challenge.arturoIsidro.app.email.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.challenge.arturoIsidro.app.email.entity.EmailEntity;

public interface EmailRepository extends JpaRepository<EmailEntity, Long> {
	
////	@Transactional
//	//@Query(value ="delete from email e where e.email=:name", nativeQuery = true)
//	void deletebyemail(String email);
//
////	@Transactional
////	@Query(value ="Select * FROM email e where e.email=:name limit=1", nativeQuery = true)
		Optional<EmailEntity> findByemail(String email);
}
