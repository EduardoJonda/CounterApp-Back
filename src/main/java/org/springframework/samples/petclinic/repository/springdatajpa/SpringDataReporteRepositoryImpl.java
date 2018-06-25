package org.springframework.samples.petclinic.repository.springdatajpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.samples.petclinic.model.Reporte;

@Profile("spring-data-jpa")
public class SpringDataReporteRepositoryImpl implements ReporteRepositoryOverride {

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public void delete(Reporte reporte) {
		String repId = reporte.getId().toString();
		this.em.createQuery("DELETE FROM Reporte reporte WHERE id=" + repId).executeUpdate();
	}
}
