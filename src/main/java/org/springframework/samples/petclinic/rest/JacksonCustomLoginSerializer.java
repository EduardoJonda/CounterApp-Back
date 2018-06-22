package org.springframework.samples.petclinic.rest;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;

import org.springframework.samples.petclinic.model.Login;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class JacksonCustomLoginSerializer extends StdSerializer<Login> {

	public JacksonCustomLoginSerializer() {
		this(null);
	}

	public JacksonCustomLoginSerializer(Class<Login> t) {
		super(t);
	}
	
	@Override
	public void serialize(Login login, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		// TODO Auto-generated method stub
		jgen.writeStartObject();
		
		if (login.getId() == null) {
			jgen.writeNullField("id");
		} else {
			jgen.writeNumberField("id", login.getId());
		}

		jgen.writeStringField("address", login.getAddress());
		jgen.writeStringField("password", login.getPassword());
		
		jgen.writeEndObject(); // login
		
	}

}
