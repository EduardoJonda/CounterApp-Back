package org.springframework.samples.petclinic.model;

public class Login2 {

	private String address;
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
		return "Login2 [address=" + address + ", password=" + password + "]";
	}
	
	
}
