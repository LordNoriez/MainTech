package org.maintech.maquina;

import java.util.Date;

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
	
	private Objeto objeto;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Mantenimiento mantenimiento;
	
	public Objeto() {
		super();
	}

	
	
}
