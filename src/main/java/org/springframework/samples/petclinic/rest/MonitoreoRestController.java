package org.springframework.samples.petclinic.rest;

import javax.validation.Valid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Reporte;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/api/monitoreo")
public class MonitoreoRestController {
	
	@Autowired
	private ClinicService clinicService;
	
	@RequestMapping(value = "/monitoreo-region", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<Reporte>> getmonitorRegion(@RequestBody @Valid MonitoreoRequest monitoreoRequest, BindingResult bindingResult,
			UriComponentsBuilder ucBuilder) {
		
		System.out.println("Monitoreo por region "+ monitoreoRequest);
		/*SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		try {
		fecha = formatoDelTexto.parse(fecha2);
		} catch (ParseException ex) {
		ex.printStackTrace();
		}
		System.out.println(fecha.toString());
		
		String hecho = fecha2.substring(0, 4);*/
		String ubicacion = monitoreoRequest.getDistrito();
		Collection<Reporte> reports2 = this.clinicService.findReporteByReporteRegion(ubicacion);
		System.out.println("Reportess region : "+ reports2);
				return new ResponseEntity<Collection<Reporte>>(reports2, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/monitoreo-delito", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<Reporte>> getmonitorDelito(@RequestBody @Valid MonitoreoRequest monitoreoRequest, BindingResult bindingResult,
			UriComponentsBuilder ucBuilder) {
		
		System.out.println("Monitoreo por delito "+ monitoreoRequest);
		String tipoDelito = monitoreoRequest.getDepartamento();
		Collection<Reporte> reports3 = this.clinicService.findReporteByReporteTipoDelito(tipoDelito);
		System.out.println("Reportess tipo delito : "+ reports3);
				return new ResponseEntity<Collection<Reporte>>(reports3, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/monitoreo-fecha", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<Reporte>> getmonitorFecha(@RequestBody @Valid MonitoreoRequest monitoreoRequest, BindingResult bindingResult,
			UriComponentsBuilder ucBuilder) {
		
		System.out.println("Monitoreo por delito "+ monitoreoRequest);
		String fecha_Año = monitoreoRequest.getDepartamento();
		Collection<Reporte> reports = this.clinicService.findReporteByReporteFecha(fecha_Año);
		System.out.println("Reportess : "+ reports);
				return new ResponseEntity<Collection<Reporte>>(reports, HttpStatus.OK);
	}
}
