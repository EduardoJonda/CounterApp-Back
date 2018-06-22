package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.samples.petclinic.rest.JacksonCustomLoginDeserializer;
import org.springframework.samples.petclinic.rest.JacksonCustomLoginSerializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "login")
@JsonSerialize(using = JacksonCustomLoginSerializer.class)
@JsonDeserialize(using = JacksonCustomLoginDeserializer.class)
public class Login extends BaseEntity{
		
	@Column(name = "address")
	@NotEmpty
	private String address;
		
	@Column(name = "password")
	@NotEmpty
	private String password;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [address=" + address + ", password=" + password + "]";
	}

}
