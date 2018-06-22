package org.springframework.samples.petclinic.rest;

import java.io.IOException;

import org.springframework.samples.petclinic.model.Login;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class JacksonCustomLoginDeserializer extends StdDeserializer<Login>{
	
	public JacksonCustomLoginDeserializer(){
		this(null);
	}

	public JacksonCustomLoginDeserializer(Class<Login> t) {
		super(t);
	}

	@Override
	public Login deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		JsonNode node = parser.getCodec().readTree(parser);
		int id = node.get("id").asInt();
		Login login = new Login();
		String address = node.get("address").asText(null);
		String password = node.get("password").asText(null);
		
		if (!(id == 0)) {
			login.setId(id);
		}
				
		login.setAddress(address);
		login.setPassword(password);
		
		return login;
	}
	
	

}
