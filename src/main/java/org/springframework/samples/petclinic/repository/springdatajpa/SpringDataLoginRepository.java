package org.springframework.samples.petclinic.repository.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Login;
import org.springframework.samples.petclinic.repository.LoginRepository;

@Profile("spring-data-jpa")
public interface SpringDataLoginRepository extends LoginRepository, Repository<Login, Integer> {

	
	 @Override
	 @Query("SELECT login FROM Login login WHERE login.address =:address")
	 public Login findAddress(@Param("address") String address);
	
}
