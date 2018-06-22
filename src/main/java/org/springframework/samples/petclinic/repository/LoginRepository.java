package org.springframework.samples.petclinic.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Login;

public interface LoginRepository {

 Login findAddress(String adress) throws DataAccessException;
	
}
