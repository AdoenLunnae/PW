package es.uco.pw.display.beans;

import java.io.Serializable;

public class CustomerBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String mail, idRol;

	public CustomerBean() {
	}

	public CustomerBean(String mail, String idRol) {
		this.mail = mail;
		this.idRol = idRol;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMail() {
		return mail;
	}

	public void setIdRol(String idRol) {
		this.idRol = idRol;
	}

	public String getIdRol() {
		return idRol;
	}

}