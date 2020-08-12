package es.uco.pw.display.beans;


public class ContactInfoBean {
	
	private String name, value;
	private int id;
	
    public ContactInfoBean() {
		this.id = 0;
        this.name = "";
        this.value = "";
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