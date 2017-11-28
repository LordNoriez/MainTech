package org.maintech.proveedor;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Where(clause="is_active=1")
public class Proveedor {
	
	@Id
	@GeneratedValue
	private Integer idProveedor;
	private String NombreProveedor;
	private String EmailProveedor;
	private String DireccionProveedor;
	private String TelefonoProveedor;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date FechaIngresoProveedor;

	@Column(name="is_active", columnDefinition="tinyint(1) default 1")	
	private Boolean active;	
	
	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombreProveedor() {
		return NombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		NombreProveedor = nombreProveedor;
	}

	public String getEmailProveedor() {
		return EmailProveedor;
	}

	public void setEmailProveedor(String emailProveedor) {
		EmailProveedor = emailProveedor;
	}

	public String getDireccionProveedor() {
		return DireccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		DireccionProveedor = direccionProveedor;
	}

	public String getTelefonoProveedor() {
		return TelefonoProveedor;
	}

	public void setTelefonoProveedor(String telefonoProveedor) {
		TelefonoProveedor = telefonoProveedor;
	}

	public Date getFechaIngresoProveedor() {
		return FechaIngresoProveedor;
	}

	public void setFechaIngresoProveedor(Date fechaIngresoProveedor) {
		FechaIngresoProveedor = fechaIngresoProveedor;
	}
	
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Proveedor() {
		super();
	}

	public Proveedor(Integer idProveedor, String nombreProveedor, String emailProveedor, String direccionProveedor,
			String telefonoProveedor, Date fechaIngresoProveedor) {
		super();
		this.idProveedor = idProveedor;
		NombreProveedor = nombreProveedor;
		EmailProveedor = emailProveedor;
		DireccionProveedor = direccionProveedor;
		TelefonoProveedor = telefonoProveedor;
		FechaIngresoProveedor = fechaIngresoProveedor;
	}	
}
