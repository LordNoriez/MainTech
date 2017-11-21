package org.maintech.objeto;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;
import org.maintech.areaempresa.AreaEmpresa;
import org.maintech.categoria.Categoria;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Where(clause="is_active=1")
public class Objeto {
	
	@Id
	@GeneratedValue
	private Integer idObjeto;
	private String MarcaObjeto;
	private String ModeloObjeto;
	private String SerialObjeto;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date FechaCreacionObjeto;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date FechaObtencionObjeto;
	private String DescripcionObjeto;
	private String LongitudObjeto;
	private String AnchoObjeto;
	private String AreaObjeto;
	private String AlturaObjeto;
	private Integer VidaObjeto;
	
	@ManyToOne
	private Objeto objetoPadre;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private AreaEmpresa AreaEmpresa;
		
	@Column(name="is_active", columnDefinition="tinyint(1) default 1")	
	private Boolean active;
		
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

	public Objeto getObjetoPadre() {
		return objetoPadre;
	}

	public void setObjetoPadre(Objeto objeto) {
		this.objetoPadre = objeto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public AreaEmpresa getAreaEmpresa() {
		return AreaEmpresa;
	}

	public void setAreaEmpresa(AreaEmpresa areaEmpresa) {
		AreaEmpresa = areaEmpresa;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Objeto() {
		super();
	}

	public Objeto(Integer idObjeto, String marcaObjeto, String modeloObjeto, String serialObjeto,
			Date fechaCreacionObjeto, Date fechaObtencionObjeto, String descripcionObjeto, String longitudObjeto,
			String anchoObjeto, String areaObjeto, String alturaObjeto, Integer vidaObjeto, Objeto objetoPadre,
			Categoria categoria, AreaEmpresa areaEmpresa) {
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
		this.objetoPadre = objetoPadre;
		this.categoria = categoria;
		this.AreaEmpresa = areaEmpresa;
	}	
}
