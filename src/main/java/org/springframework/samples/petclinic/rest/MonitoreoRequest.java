package org.springframework.samples.petclinic.rest;

public class MonitoreoRequest {
	
	private String departamento, distrito;

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	@Override
	public String toString() {
		return "MonitoreoRequest [departamento=" + departamento + ", distrito=" + distrito + "]";
	}
	
}
