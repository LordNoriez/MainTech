package org.maintech.objeto;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.maintech.categoria.Categoria;
import org.maintech.mantenimiento.Mantenimiento;

@Entity
public class Objeto {
	
	@Id
	private Integer idObjeto;
	private String MarcaObjeto;
	private String ModeloObjeto;
	private String SerialObjeto;
	private Date FechaCreacionObjeto;
	private Date FechaObtencionObjeto;
	private String DescripcionObjeto;
	private String LongitudObjeto;
	private String AnchoObjeto;
	private String AreaObjeto;
	private String AlturaObjeto;
	private Integer VidaObjeto;
	
	@ManyToOne
	private Objeto objeto;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Mantenimiento mantenimiento;
		
	public Integer getIdObjeto() {
		return idObjeto;
	}

	public void setIdObjeto(Integer idObjeto) {
		this.idObjeto = idObjeto;
	}

	public String getMarcaObjeto() {
		return MarcaObjeto;
	}

	public void setMarcaObjeto(String marcaObjeto) {
		MarcaObjeto = marcaObjeto;
	}

	public String getModeloObjeto() {
		return ModeloObjeto;
	}

	public void setModeloObjeto(String modeloObjeto) {
		ModeloObjeto = modeloObjeto;
	}

	public String getSerialObjeto() {
		return SerialObjeto;
	}

	public void setSerialObjeto(String serialObjeto) {
		SerialObjeto = serialObjeto;
	}

	public Date getFechaCreacionObjeto() {
		return FechaCreacionObjeto;
	}

	public void setFechaCreacionObjeto(Date fechaCreacionObjeto) {
		FechaCreacionObjeto = fechaCreacionObjeto;
	}

	public Date getFechaObtencionObjeto() {
		return FechaObtencionObjeto;
	}

	public void setFechaObtencionObjeto(Date fechaObtencionObjeto) {
		FechaObtencionObjeto = fechaObtencionObjeto;
	}

	public String getDescripcionObjeto() {
		return DescripcionObjeto;
	}

	public void setDescripcionObjeto(String descripcionObjeto) {
		DescripcionObjeto = descripcionObjeto;
	}

	public String getLongitudObjeto() {
		return LongitudObjeto;
	}

	public void setLongitudObjeto(String longitudObjeto) {
		LongitudObjeto = longitudObjeto;
	}

	public String getAnchoObjeto() {
		return AnchoObjeto;
	}

	public void setAnchoObjeto(String anchoObjeto) {
		AnchoObjeto = anchoObjeto;
	}

	public String getAreaObjeto() {
		return AreaObjeto;
	}

	public void setAreaObjeto(String areaObjeto) {
		AreaObjeto = areaObjeto;
	}

	public String getAlturaObjeto() {
		return AlturaObjeto;
	}

	public void setAlturaObjeto(String alturaObjeto) {
		AlturaObjeto = alturaObjeto;
	}

	public Integer getVidaObjeto() {
		return VidaObjeto;
	}

	public void setVidaObjeto(Integer vidaObjeto) {
		VidaObjeto = vidaObjeto;
	}

	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Mantenimiento getMantenimiento() {
		return mantenimiento;
	}

	public void setMantenimiento(Mantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	public Objeto() {
		super();
	}

	public Objeto(Integer idObjeto, String marcaObjeto, String modeloObjeto, String serialObjeto,
			Date fechaCreacionObjeto, Date fechaObtencionObjeto, String descripcionObjeto, String longitudObjeto,
			String anchoObjeto, String areaObjeto, String alturaObjeto, Integer vidaObjeto, Objeto objeto,
			Categoria categoria, Mantenimiento mantenimiento) {
		super();
		this.idObjeto = idObjeto;
		MarcaObjeto = marcaObjeto;
		ModeloObjeto = modeloObjeto;
		SerialObjeto = serialObjeto;
		FechaCreacionObjeto = fechaCreacionObjeto;
		FechaObtencionObjeto = fechaObtencionObjeto;
		DescripcionObjeto = descripcionObjeto;
		LongitudObjeto = longitudObjeto;
		AnchoObjeto = anchoObjeto;
		AreaObjeto = areaObjeto;
		AlturaObjeto = alturaObjeto;
		VidaObjeto = vidaObjeto;
		this.objeto = objeto;
		this.categoria = categoria;
		this.mantenimiento = mantenimiento;
	}

	
	
}
