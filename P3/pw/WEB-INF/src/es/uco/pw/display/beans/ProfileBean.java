package es.uco.pw.display.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import es.uco.pw.display.beans.ExperienceBean;

public class ProfileBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String mail, name, aboutMe, phone;
	private Hashtable<String, String> contactData;
	private ArrayList<ExperienceBean> experiences;
	
	public ProfileBean() {
		super();
	}

	public ProfileBean(String email, String name, String aboutMe, String phone, ArrayList<ExperienceBean> experiences) {
		super();
		this.mail = email;
		this.name = name;
		this.aboutMe = aboutMe;
		this.phone = phone;
		this.experiences = experiences;
	}

	public ArrayList<ExperienceBean> getExperiences() {
		return experiences;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Hashtable<String, String> getContactData() {
		return contactData;
	}


}