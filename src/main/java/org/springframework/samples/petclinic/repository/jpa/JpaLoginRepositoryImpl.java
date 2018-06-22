package org.springframework.samples.petclinic.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Login;
import org.springframework.samples.petclinic.repository.LoginRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jpa")
public class JpaLoginRepositoryImpl implements LoginRepository{
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public Login findAddress(String adress) throws DataAccessException {
		
		Query query = this.em.createQuery("SELECT login FROM Login login WHERE login.address =:address");
		query.setParameter("address", adress);
		
		return (Login) query.getSingleResult();
	}

}
