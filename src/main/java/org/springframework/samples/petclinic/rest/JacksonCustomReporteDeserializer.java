package org.springframework.samples.petclinic.rest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Reporte;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class JacksonCustomReporteDeserializer extends StdDeserializer<Reporte>{

	public JacksonCustomReporteDeserializer() {
		this(null);
	}

	public JacksonCustomReporteDeserializer(Class<Reporte> t) {
		super(t);
	}
	
	@Override
	public Reporte deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		Reporte reporte = new Reporte();
		Owner owner = new Owner();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = parser.getCodec().readTree(parser);
		JsonNode owner_node = node.get("owner");
		owner = mapper.treeToValue(owner_node, Owner.class);
		// Date fecha_creacion = null;
		
		int reporteId = node.get("id").asInt();
		String delito = node.get("delito").asText(null);
		String tipo_delito = node.get("tipo_delito").asText(null);
		String ubicacion = node.get("ubicacion").asText(null);
		String latitud = node.get("latitud").asText(null);
		String longitud = node.get("longitud").asText(null);
		String descripcion_delito = node.get("descripcion_delito").asText(null);
		String descripcion_delincuente = node.get("descripcion_delincuente").asText(null);
		String estado = node.get("name").asText(null);
		String fecha_creacionStr = node.get("fecha_creacion").asText(null);
		/*try {
			fecha_creacion = formatter.parse(fecha_creacionStr);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new IOException(e);
		}*/
		
		if (!(reporteId == 0)) {
			reporte.setId(reporteId);
		}
		
		reporte.setDelito(delito);
		reporte.setTipo_delito(tipo_delito);
		reporte.setUbicacion(ubicacion);
		reporte.setLatitud(latitud);
		reporte.setLongitud(longitud);
		reporte.setDescripcion_delito(descripcion_delito);
		reporte.setDescripcion_delincuente(descripcion_delincuente);
		reporte.setEstado(estado);
		reporte.setFecha_creacion(fecha_creacionStr);
		
		return reporte;
	}

}
