package es.uco.pw.display.beans;

import java.io.Serializable;
import java.util.Date;

public class ExperienceBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date start, end;
	private String nombre, descripcion;

	public ExperienceBean() {
	}

	public ExperienceBean(Date start, Date end, String nombre, String descripcion) {
		super();
		this.start = start;
		this.end = end;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
