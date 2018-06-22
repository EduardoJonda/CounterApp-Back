package org.springframework.samples.petclinic.rest;

import java.io.IOException;

import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Reporte;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class JacksonCustomReporteSerializer extends StdSerializer<Reporte>{

	public JacksonCustomReporteSerializer() {
		this(null);
	}

	public JacksonCustomReporteSerializer(Class<Reporte> t) {
		super(t);
	}
	
	@Override
	public void serialize(Reporte reporte, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		// TODO Auto-generated method stub
		
		jgen.writeStartObject();
		if (reporte.getId() == null) {
			jgen.writeNullField("id");
		} else {
			jgen.writeNumberField("id", reporte.getId());
		}
		
		jgen.writeStringField("delito", reporte.getDelito());
		jgen.writeStringField("tipo_delito", reporte.getDelito());
		jgen.writeStringField("ubicacion", reporte.getDelito());
		jgen.writeStringField("latitud", reporte.getDelito());
		jgen.writeStringField("longitud", reporte.getDelito());
		jgen.writeStringField("descripcion_delito", reporte.getDelito());
		jgen.writeStringField("descripcion_delincuente", reporte.getDelito());
		jgen.writeStringField("estado", reporte.getDelito());
		jgen.writeStringField("fecha_creacion", reporte.getDelito());
		
		Owner owner = reporte.getOwner();
		jgen.writeObjectFieldStart("owner");
		jgen.writeNumberField("id", owner.getId());
		jgen.writeStringField("firstName", owner.getFirstName());
		jgen.writeStringField("lastName", owner.getLastName());
		jgen.writeStringField("address", owner.getAddress());
		jgen.writeStringField("city", owner.getCity());
		jgen.writeStringField("telephone", owner.getTelephone());
		jgen.writeEndObject(); // owner
	
	}

}
