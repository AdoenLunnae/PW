package es.uco.pw.display.beans;

import java.io.Serializable;

public class ContactInfoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name, value;
	private int id;

	public ContactInfoBean() {
		this.id = 0;
		this.name = ""; //$NON-NLS-1$
		this.value = ""; //$NON-NLS-1$
	}

	public ContactInfoBean(int id, String name, String value) {
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}