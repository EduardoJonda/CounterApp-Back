package org.springframework.samples.petclinic.repository.springdatajpa;

import java.util.Collection;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Reporte;
import org.springframework.samples.petclinic.repository.ReporteRepository;

@Profile("spring-data-jpa")
public interface SpringDataReporteRepository extends ReporteRepository, Repository<Reporte, Integer>, ReporteRepositoryOverride{
	
    @Override
    @Query("SELECT reporte FROM Reporte reporte WHERE reporte.id =:id")
    public Reporte findById(@Param("id") int id);
    
    @Override
    @Query("SELECT DISTINCT reporte FROM Reporte reporte WHERE reporte.estado LIKE :estado%")
    public Collection<Reporte> findByEstado(@Param("estado") String estado);
    
    @Override
    @Query("SELECT DISTINCT reporte FROM Reporte reporte WHERE reporte.tipo_delito LIKE :tipo_delito%")
    public Collection<Reporte> findByTipoDelito(@Param("tipo_delito") String tipo_delito);

}
