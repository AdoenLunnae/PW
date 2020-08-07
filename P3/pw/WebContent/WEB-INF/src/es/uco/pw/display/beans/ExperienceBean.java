package es.uco.pw.display.beans;

import java.io.Serializable;
import java.util.Date;

public class ExperienceBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date start, end;
	private String nombre, descripcion, lugar;

	public ExperienceBean() {
	}

	public ExperienceBean(Date start, Date end, String nombre, String descripcion, String lugar) {
		super();
		this.start = start;
		this.end = end;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.lugar = lugar;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
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
