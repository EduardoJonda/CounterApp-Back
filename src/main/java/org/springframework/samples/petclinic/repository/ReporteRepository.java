package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Reporte;

public interface ReporteRepository {

	Collection<Reporte> findAll() throws DataAccessException;
	
	Reporte findById(int id) throws DataAccessException;
	
	void save(Reporte reporte) throws DataAccessException;
	
	void delete(Reporte reporte) throws DataAccessException;

}
