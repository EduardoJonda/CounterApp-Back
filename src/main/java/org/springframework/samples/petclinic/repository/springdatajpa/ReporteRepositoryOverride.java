package org.springframework.samples.petclinic.repository.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.samples.petclinic.model.Reporte;

@Profile("spring-data-jpa")
public interface ReporteRepositoryOverride {
	
	public void delete(Reporte reporte);

}
