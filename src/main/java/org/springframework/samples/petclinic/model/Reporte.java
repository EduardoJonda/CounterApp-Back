package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "reportes")
//@JsonSerialize(using = JacksonCustomReporteSerializer.class)
//@JsonDeserialize(using = JacksonCustomReporteDeserializer.class)

public class Reporte extends BaseEntity {
	
	@Column(name = "delito")
	@NotEmpty
	private String delito;
	
	@Column(name = "tipo_delito")
	@NotEmpty
	private String tipo_delito;
	
	@Column(name = "ubicacion")
	@NotEmpty
	private String ubicacion;
	
	@Column(name = "latitud")
	@NotEmpty
	private String latitud;
	
	@Column(name = "longitud")
	@NotEmpty
	private String longitud;
	
	@Column(name = "descripcion_delito")
	@NotEmpty
	private String descripcion_delito;
	
	@Column(name = "descripcion_delincuente")
	@NotEmpty
	private String descripcion_delincuente;
	
	@Column(name = "estado")
	@NotEmpty
	private String estado;
	
	@Column(name = "fecha_creacion")
	@NotEmpty
	private String fecha_creacion;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	@NotEmpty
	private Owner owner;

	public String getDelito() {
		return delito;
	}

	public void setDelito(String delito) {
		this.delito = delito;
	}

	public String getTipo_delito() {
		return tipo_delito;
	}

	public void setTipo_delito(String tipo_delito) {
		this.tipo_delito = tipo_delito;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getDescripcion_delito() {
		return descripcion_delito;
	}

	public void setDescripcion_delito(String descripcion_delito) {
		this.descripcion_delito = descripcion_delito;
	}

	public String getDescripcion_delincuente() {
		return descripcion_delincuente;
	}

	public void setDescripcion_delincuente(String descripcion_delincuente) {
		this.descripcion_delincuente = descripcion_delincuente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Reporte [delito=" + delito + ", tipo_delito=" + tipo_delito + ", ubicacion=" + ubicacion + ", latitud="
				+ latitud + ", longitud=" + longitud + ", descripcion_delito=" + descripcion_delito
				+ ", descripcion_delincuente=" + descripcion_delincuente + ", estado=" + estado + ", fecha_creacion="
				+ fecha_creacion + ", owner=" + owner + "]";
	}
	
}
