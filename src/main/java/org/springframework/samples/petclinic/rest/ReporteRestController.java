package org.springframework.samples.petclinic.rest;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Reporte;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/api/owners")
public class ReporteRestController {
	
	@Autowired
	private ClinicService clinicService;
	
	@RequestMapping(value = "/reportes/{reporteId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Reporte> getReporte(@PathVariable("reporteId") int reporteId) {
		
		System.out.println("Peticion de reporte en especifico");
		Reporte report = this.clinicService.findReporteById(reporteId);
		if (report == null) {
			return new ResponseEntity<Reporte>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Reporte>(report, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/reporte/valid/aprobe/{reporteId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Reporte> validAprobeReporte(@PathVariable("reporteId") int reporteId) {
		
		System.out.println("Validando como Aprobado");
		Reporte report = this.clinicService.findReporteById(reporteId);
		if (report == null) {
			return new ResponseEntity<Reporte>(HttpStatus.NOT_FOUND);
		}

		System.out.println("Reporte obtenido :"+report);
		String AprobReport = "Aprobado";
		report.setEstado(AprobReport);
		System.out.println("Reporte Validado :"+report);
		
		this.clinicService.saveReporte(report);
		return new ResponseEntity<Reporte>(report, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/reporte/valid/delete/{reporteId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Transactional
	public ResponseEntity<Void> validDeleteReporte(@PathVariable("reporteId") int reporteId) {
		
		System.out.println("Validando como Eliminado");
		Reporte report = this.clinicService.findReporteById(reporteId);
		if (report == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		System.out.println("Reporte a Eliminar :"+report);
		this.clinicService.deleteReporte(report);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
